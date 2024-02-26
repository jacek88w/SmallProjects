function createInputWindow() {
    // Create a popup window
    var inputWindow = document.createElement("div");
    inputWindow.style.border = "2px solid #000";
    inputWindow.style.padding = "20px";
    inputWindow.style.width = "300px";
    inputWindow.style.margin = "0 auto";
    inputWindow.style.marginTop = "50px";

    // Ticket Priority Input
    var selectLabel = document.createElement("label");
    selectLabel.textContent = "Select Option: ";
    var select = document.createElement("select");
    var ticketPriority = ["Low", "Medium", "High"];
    ticketPriority.forEach(function(option) {
        var optionElement = document.createElement("option");
        optionElement.value = option.toLowerCase();
        optionElement.textContent = option;
        select.appendChild(optionElement);
    });
    selectLabel.appendChild(select);
    inputWindow.appendChild(selectLabel);
    inputWindow.appendChild(document.createElement("br"));

    // LoopDelay Input
    var input1Label = document.createElement("label");
    input1Label.textContent = "Delay between checks (seconds): ";
    var input1 = document.createElement("input");
    input1.type = "number";
    input1.style.marginBottom = "10px";
    input1Label.appendChild(input1);
    inputWindow.appendChild(input1Label);
    inputWindow.appendChild(document.createElement("br"));

    // Duration Input
    var input2Label = document.createElement("label");
    input2Label.textContent = "Duration Time (minutes): ";
    var input2 = document.createElement("input");
    input2.type = "number";
    input2.style.marginBottom = "10px";
    input2Label.appendChild(input2);
    inputWindow.appendChild(input2Label);
    inputWindow.appendChild(document.createElement("br"));

    // Create submit button
    var submitButton = document.createElement("button");
    submitButton.textContent = "Submit";
    submitButton.style.marginRight = "10px";
    submitButton.onclick = function() {
        handleSubmit(select.value, input1.value, input2.value);
    };
    inputWindow.appendChild(submitButton);

    // Append the window to the body
    document.body.appendChild(inputWindow);

    // Return the inputWindow for further manipulation if needed
    return inputWindow;
}

function handleSubmit(ticketPriority, input1, input2) {
    console.log("Priority:", ticketPriority);
    console.log("Duration:", input1 + " minutes");
    console.log("Delay:", input2 + " seconds");

    checkTicketPresence(ticketPriority, input1, input2);
}

// Call the function to create the input window
var popupWindow = createInputWindow();

// Open the popup window
var popup = window.open('', '_blank', 'width=400,height=300');
popup.document.body.appendChild(popupWindow);

    function convertPriorityToClassName(priority) {

    }

    // Ticket checking function
    function checkTicketPresence(className, duration, delay) {
    duration = duration*60;
    var attempts = 0;
    var maxAttempts = duration/delay;

        console.log("duration:" + duration);
        console.log("max" + maxAttempts);

    function check() {
        var divs = document.getElementsByClassName(className);

        if (divs.length > 0) {
            console.log("Element with class '" + className + "' is present.");
            return true;
        } else {
            attempts++;
            if (attempts < maxAttempts) {
                console.log("Element with class '" + className + "' is not present. Attempt: " + attempts);
                setTimeout(check, delay * 1000);
            } else {
                console.log("Loop stopped, time expired. Ticket with priority '" + className + "' was not present.");
                return false;
            }
        }
    }

    // Start the checking process
    check();
}