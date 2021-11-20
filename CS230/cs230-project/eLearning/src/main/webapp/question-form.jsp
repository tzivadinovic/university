<%

%>

<form action="${pageContext.request.contextPath}/add-question" method="post">
    <h6>Question Text:</h6>
    <input type="text" name="text"/>
    <h6>Points:</h6>
    <input type="number" name="points" min="1"/>
    <h6>Answers:</h6>
    <div>
        <textarea class="materialize-textarea" type="text" name="answer1text"></textarea>
        <p>
            <label>
                <input type="checkbox" class="filled-in" checked="checked" name="answer1correct"/>
                <span>Correct</span>
            </label>
        </p>
    </div>
    <div>
        <textarea class="materialize-textarea" type="text" name="answer2text"></textarea>
        <p>
            <label>
                <input type="checkbox" class="filled-in" checked="checked" name="answer2correct"/>
                <span>Correct</span>
            </label>
        </p>
    </div>
    <div>
        <textarea class="materialize-textarea" type="text" name="answer3text"></textarea>
        <p>
            <label>
                <input type="checkbox" class="filled-in" checked="checked" name="answer3correct"/>
                <span>Correct</span>
            </label>
        </p>
    </div>
    <div>
        <textarea class="materialize-textarea" type="text" name="answer4text"></textarea>
        <p>
            <label>
                <input type="checkbox" class="filled-in" checked="checked" name="answer4correct"/>
                <span>Correct</span>
            </label>
        </p>
    </div>

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
        margin-top: 4%;
    }

    body {
        background-image: linear-gradient(to right, #2a4078, #4062b7);
    }

    h6 {
        color: white;
    }
</style>