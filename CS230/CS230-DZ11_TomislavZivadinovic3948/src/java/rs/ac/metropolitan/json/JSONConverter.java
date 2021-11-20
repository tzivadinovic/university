package rs.ac.metropolitan.json;

import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

@Named
@SessionScoped
public class JSONConverter implements Serializable {

    @Inject
    private Osoba osoba;

    private String jsonString;

    public JSONConverter() {
    }

    public String getJsonString() {
        return jsonString;
    }

    public void setJsonString(String jsonString) {
        this.jsonString = jsonString;
    }

    public String generateJsonAPIO() {
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();

        /* JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        osoba.getBrojeviTelefona().forEach((num) -> {
            jsonArrayBuilder.add(num);
        });
        JsonArray jsonArray = jsonArrayBuilder.build();*/
        JsonObject jsonObjectAdresa = jsonObjectBuilder.add("ulica", osoba.getAdresa().getUlica()).
                add("grad", osoba.getAdresa().getGrad()).
                add("postanskiBroj", osoba.getAdresa().getPostanskiBroj()).build();
        JsonObject jsonObjectOsoba = jsonObjectBuilder.add("brojIndeksa", osoba.getBrojIndeksa()).
                add("ime", osoba.getIme()).
                add("status", osoba.getStatus()).
                add("tradicionalni", osoba.getTradicionalni()).
                add("adresa", jsonObjectAdresa).
                //add("brojeviTelefona", jsonArray).
                add("uloga", osoba.getUloga()).build();
        StringWriter stringWriter = new StringWriter();
        try (JsonWriter jsonWriter = Json.createWriter(stringWriter)) {
            jsonWriter.writeObject(jsonObjectOsoba);
        }
        setJsonString(stringWriter.toString());
        return "generated_json";
    }

    public String parseJsonAPIO() {
        JsonObject jsonObject;
        try (JsonReader jsonReader = Json.createReader(new StringReader(jsonString))) {
            jsonObject = jsonReader.readObject();
        }
        osoba.setIme(jsonObject.getString("ime"));
        osoba.setStatus(jsonObject.getString("status"));
        osoba.setUloga(jsonObject.getString("uloga"));
        osoba.setTradicionalni(jsonObject.getBoolean("tradicionalni"));
        osoba.setBrojIndeksa(jsonObject.getInt("brojIndeksa"));
        return "parsed_json";
    }

    public String generateJsonAPITokovi() {
        StringWriter stringWriter1 = new StringWriter();
        StringWriter stringWriter = new StringWriter();
        try (JsonGenerator jsonGenerator = Json.createGenerator(stringWriter1)) {
            jsonGenerator.writeStartObject().write("ulica", osoba.getAdresa().getUlica()).
                    write("grad", osoba.getAdresa().getGrad()).
                    write("postanskiBroj", osoba.getAdresa().getPostanskiBroj()).writeEnd();
        }
        try (JsonGenerator jsonGenerator = Json.createGenerator(stringWriter)) {
            jsonGenerator.writeStartObject().write("ime", osoba.getIme()).
                    write("status", osoba.getStatus()).
                    write("tradicionalni", osoba.getTradicionalni()).
                    write("brojIndeksa", osoba.getBrojIndeksa()).
                    write("adresa", stringWriter1.toString()).
                    write("uloga", osoba.getUloga()).writeEnd();

        }

        setJsonString(stringWriter.toString());

        return "generated_json";
    }

    public String parseJsonAPITokovi() {
        StringReader stringReader = new StringReader(jsonString);
        JsonParser jsonParser = Json.createParser(stringReader);
        Map<String, Object> jsonMap = new HashMap<>();
        String jsonKeyNm = null;
        Object jsonVal = null;
        while (jsonParser.hasNext()) {
            JsonParser.Event event = jsonParser.next();
            if (event.equals(Event.KEY_NAME)) {
                jsonKeyNm = jsonParser.getString();
            } else if (event.equals(Event.VALUE_STRING)) {
                jsonVal = jsonParser.getString();
            } else if (event.equals(Event.VALUE_NUMBER)) {
                jsonVal = jsonParser.getInt();
            }
            jsonMap.put(jsonKeyNm, jsonVal);
        }
        osoba.setIme((String) jsonMap.get("ime"));
        osoba.setStatus((String) jsonMap.get("status"));
        osoba.setUloga((String) jsonMap.get("uloga"));
        osoba.setTradicionalni(Boolean.parseBoolean(jsonMap.get("tradicionalni").toString()));
        osoba.setBrojIndeksa(Integer.parseInt(jsonMap.get("brojIndeksa").toString()));
        return "parsed_json";
    }

}
