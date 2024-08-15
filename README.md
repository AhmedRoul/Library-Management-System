<div class="flex w-full flex-col gap-1 empty:hidden first:pt-[3px]">
    <div class="markdown prose w-full break-words dark:prose-invert dark">
        <p>Certainly! Here's a compiled document that includes all the sections discussed:</p>
        <hr>
        <h1>Library Management System Documentation</h1>
        <h2>Table of Contents</h2>
        <ol>
            <li><a rel="noopener" href="#introduction">Introduction</a></li>
            <li><a rel="noopener" href="#running-the-application">Running the Application</a></li>
            <li><a rel="noopener" href="#interacting-with-api-endpoints">Interacting with API Endpoints</a></li>
            <li><a rel="noopener" href="#authentication">Authentication</a></li>
            <li><a rel="noopener" href="#password-management">Password Management</a></li>
            <li><a rel="noopener" href="#caching">Caching</a></li>
            <li><a rel="noopener" href="#aspects">Aspects</a></li>
        </ol>
        <hr>
        <h2 id="introduction">Introduction</h2>
        <p>This document provides comprehensive information on how to run the Library Management System, interact with its API endpoints, and understand the implemented authentication, password management, caching, and aspects.</p>
        
        <h2 id="running-the-application">Running the Application</h2>
        <ol>
            <li><strong>Clone the Repository</strong>: Begin by cloning the repository to your local machine.</li>
            <pre><code>git clone https://github.com/AhmedRoul/Library-Management-System/</code></pre>
            <li><strong>Build the Project</strong>: Navigate to the project directory and build the project using Maven or Gradle.</li>
            <pre><code>mvn clean install</code></pre>
            <li><strong>Run the Application</strong>: Use the following command to run the Spring Boot application.</li>
            <pre><code>mvn spring-boot:run</code></pre>
            <li><strong>Access the Application</strong>: Once the application is running, you can access it at <code>http://localhost:9100</code>.</li>
        </ol>

        <h2 id="interacting-with-api-endpoints">Interacting with API Endpoints</h2>
        <p>The Library Management System provides several API endpoints for managing books, users, and borrowing activities. Below is a summary of the main controllers and their endpoints:</p>
        <ul>
            <li>
                <strong>BookController</strong>: Manages books in the library.
                <ul>
                    <li><strong>GET /books</strong>: Retrieve a list of all books in the library. No authentication required.</li>
                    <li><strong>GET /books/{id}</strong>: Retrieve details of a specific book by its ID. No authentication required.</li>
                    <li><strong>POST /books</strong>: Add a new book to the library. Authentication required (JWT token in Authorization header).</li>
                    <li><strong>PUT /books/{id}</strong>: Update the details of an existing book. Authentication required (JWT token in Authorization header).</li>
                    <li><strong>DELETE /books/{id}</strong>: Remove a book from the library. Authentication required (JWT token in Authorization header).</li>
                </ul>
            </li>

            <li>
                <h3>Patron Endpoints</h3>
                <ul>
                    <li><strong>GET /api/patrons</strong>: Retrieves a list of all patrons.</li>
                    <li><strong>GET /api/patrons/{id}</strong>: Retrieves a patron by ID.</li>
                    <li><strong>POST /api/patrons</strong>: Adds a new patron to the system.</li>
                    <li><strong>PUT /api/patrons/{id}</strong>: Updates an existing patron's details.</li>
                    <li><strong>DELETE /api/patrons/{id}</strong>: Deletes a patron by ID.</li>
                </ul>
            </li>

            <li>
                <h3>Borrowing Record Endpoints</h3>
                <ul>
                    <li><strong>POST /api/borrow/{bookId}/patron/{patronId}</strong>: Creates a new borrowing record for a specific book and patron.</li>
                    <li><strong>POST /api/return/{bookId}/patron/{patronId}</strong>: Returns a borrowed book.</li>
                    <li><strong>GET /api/borrow/{patronId}</strong>: Retrieves a list of all books borrowed by a specific patron.</li>
                </ul>
            </li>

            <li>
                <h3>Login Endpoints</h3>
                <ul>
                    <li><strong>POST /api/login</strong>: Authenticates a user and returns a JWT token.</li>
                </ul>
            </li>
        </ul>

        <h2 id="authentication">Authentication</h2>
        <p>The Library Management System uses JWT (JSON Web Tokens) for authentication. Users must provide a valid JWT token in the <code>Authorization</code> header of their requests to access protected endpoints.</p>

        <h2 id="password-management">Password Management</h2>
        <p>Password management in the system involves hashing passwords before storage. The system uses a secure hashing algorithm to ensure password security.</p>

        <h2 id="caching">Caching</h2>
        <p>Caching is implemented to optimize performance and reduce load times. The application uses caching for frequently accessed data, such as book details and user information.</p>

        <h2 id="aspects">Aspects</h2>
        <p>Aspects are used to handle cross-cutting concerns such as logging and transaction management. An aspect is used in the system to log all POST requests made to the API.</p>

        <hr>
        <p>Feel free to review the above sections and let me know if there are any changes or additional details you would like to include!</p>
    </div>
</div>
