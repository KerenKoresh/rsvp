document.addEventListener('DOMContentLoaded', function () {
    const loginForm = document.getElementById('loginForm');
    const loginMessage = document.getElementById('loginMessage');

    loginForm.addEventListener('submit', function (event) {
        event.preventDefault();

        const username = loginForm.username.value;
        const password = loginForm.password.value;

        // Perform basic validation
        if (username === '' || password === '') {
            loginMessage.textContent = 'Please enter both username and password.';
            loginMessage.style.color = 'red';
        } else {
            // Simulate authentication (replace this with your actual authentication logic)
            if (username === 'demo' && password === 'password') {
                loginMessage.textContent = 'Login successful!';
                loginMessage.style.color = 'green';
                // Redirect to another page or perform further actions
                // Example: window.location.href = '/dashboard';
            } else {
                loginMessage.textContent = 'Invalid username or password.';
                loginMessage.style.color = 'red';
            }
        }
    });
});
