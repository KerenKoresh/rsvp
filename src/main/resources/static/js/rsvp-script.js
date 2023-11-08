document.addEventListener('DOMContentLoaded', function () {
    const rsvpForm = document.getElementById('rsvpForm');
    const rsvpList = document.querySelector('.rsvp-list ul');

    rsvpForm.addEventListener('submit', function (event) {
        event.preventDefault();

        // Get the form data
        const formData = new FormData(rsvpForm);
        const name = formData.get('name');
        const email = formData.get('email');
        const attending = formData.get('attending');
        const guests = formData.get('guests');
        const comments = formData.get('comments');

        // Create an RSVP object
        const rsvp = {
            name,
            email,
            attending,
            guests,
            comments
        };

        // Display the RSVP in the list
        displayRSVP(rsvp);

        // Clear the form
        rsvpForm.reset();
    });

    // Function to display the RSVP in the list
    function displayRSVP(rsvp) {
        const listItem = document.createElement('li');
        listItem.innerHTML = `
            <strong>Name:</strong> ${rsvp.name}<br>
            <strong>Email:</strong> ${rsvp.email}<br>
            <strong>Attending:</strong> ${rsvp.attending === 'yes' ? 'Yes' : 'No'}<br>
            <strong>Guests:</strong> ${rsvp.guests}<br>
            <strong>Comments:</strong> ${rsvp.comments}
        `;

        rsvpList.appendChild(listItem);
    }
});
