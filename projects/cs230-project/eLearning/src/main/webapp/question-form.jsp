<form action="add-question.jsp" method="post">
    <h6>Question Text:</h6>
    <input type="text" name="text"/>
    <h6>Answer:</h6>
    <input type="text" name="answer"/>
    <h6>Points:</h6>
    <input type="number" name="points" min="1"/>

    <button class="btn waves-effect waves-light blue" type="submit" name="action">Submit
        <i class="material-icons right">send</i>
    </button>
</form>

<style>
    input[type=text] {
        width: 100px;
        color: white;
    }

    input[type=number] {
        color: white;
    }

    form {
        width: 20%;
        text-align: center;
        margin-left: 40%;
        margin-top: 8%;
    }

    body {
        background-image: linear-gradient(to right, #2a4078, #4062b7);
    }

    h6 {
        color: white;
    }
</style>