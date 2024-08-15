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
        <h2>Introduction</h2>
        <p>This document provides comprehensive information on how to run the Library Management System, interact with its API endpoints, and understand the implemented authentication, password management, caching, and aspects.</p>
        <h2>Running the Application</h2>
        <ol>
            <li>
                <p><strong>Clone the Repository</strong>: Begin by cloning the repository to your local machine.</p><pre><div class="dark bg-gray-950 rounded-md border-[0.5px] border-token-border-medium"><div class="flex items-center relative text-token-text-secondary bg-token-main-surface-secondary px-4 py-2 text-xs font-sans justify-between rounded-t-md"><div class="flex items-center"><span class="" data-state="closed"><button class="flex gap-1 items-center"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24" class="icon-sm"><path fill="currentColor" fill-rule="evenodd" d="M7 5a3 3 0 0 1 3-3h9a3 3 0 0 1 3 3v9a3 3 0 0 1-3 3h-2v2a3 3 0 0 1-3 3H5a3 3 0 0 1-3-3v-9a3 3 0 0 1 3-3h2zm2 2h5a3 3 0 0 1 3 3v5h2a1 1 0 0 0 1-1V5a1 1 0 0 0-1-1h-9a1 1 0 0 0-1 1zM5 9a1 1 0 0 0-1 1v9a1 1 0 0 0 1 1h9a1 1 0 0 0 1-1v-9a1 1 0 0 0-1-1z" clip-rule="evenodd"></path></svg></button></span></div></div><div class="overflow-y-auto p-4" dir="ltr"><code class="!whitespace-pre hljs language-bash">git <span class="hljs-built_in">clone</span>  (https://github.com/AhmedRoul/Library-Management-System/)
</code></div></div></pre></li>
            <li>
                <p><strong>Build the Project</strong>: Navigate to the project directory and build the project using Maven or Gradle.</p><pre><div class="dark bg-gray-950 rounded-md border-[0.5px] border-token-border-medium"><div class="flex items-center relative text-token-text-secondary bg-token-main-surface-secondary px-4 py-2 text-xs font-sans justify-between rounded-t-md"><span></span><div class="flex items-center"><span class="" data-state="closed"><button class="flex gap-1 items-center"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24" class="icon-sm"><path fill="currentColor" fill-rule="evenodd" d="M7 5a3 3 0 0 1 3-3h9a3 3 0 0 1 3 3v9a3 3 0 0 1-3 3h-2v2a3 3 0 0 1-3 3H5a3 3 0 0 1-3-3v-9a3 3 0 0 1 3-3h2zm2 2h5a3 3 0 0 1 3 3v5h2a1 1 0 0 0 1-1V5a1 1 0 0 0-1-1h-9a1 1 0 0 0-1 1zM5 9a1 1 0 0 0-1 1v9a1 1 0 0 0 1 1h9a1 1 0 0 0 1-1v-9a1 1 0 0 0-1-1z" clip-rule="evenodd"></path></svg></button></span></div></div><div class="overflow-y-auto p-4" dir="ltr"><code class="!whitespace-pre hljs language-bash">mvn clean install
</code></div></div></pre></li>
            <li>
                <p><strong>Run the Application</strong>: Use the following command to run the Spring Boot application.</p><pre><div class="dark bg-gray-950 rounded-md border-[0.5px] border-token-border-medium"><div class="flex items-center relative text-token-text-secondary bg-token-main-surface-secondary px-4 py-2 text-xs font-sans justify-between rounded-t-md"><span></span><div class="flex items-center"><span class="" data-state="closed"><button class="flex gap-1 items-center"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24" class="icon-sm"><path fill="currentColor" fill-rule="evenodd" d="M7 5a3 3 0 0 1 3-3h9a3 3 0 0 1 3 3v9a3 3 0 0 1-3 3h-2v2a3 3 0 0 1-3 3H5a3 3 0 0 1-3-3v-9a3 3 0 0 1 3-3h2zm2 2h5a3 3 0 0 1 3 3v5h2a1 1 0 0 0 1-1V5a1 1 0 0 0-1-1h-9a1 1 0 0 0-1 1zM5 9a1 1 0 0 0-1 1v9a1 1 0 0 0 1 1h9a1 1 0 0 0 1-1v-9a1 1 0 0 0-1-1z" clip-rule="evenodd"></path></svg></button></span></div></div><div class="overflow-y-auto p-4" dir="ltr"><code class="!whitespace-pre hljs language-bash">mvn spring-boot:run
</code></div></div></pre></li>
            <li>
                <p><strong>Access the Application</strong>: Once the application is running, you can access it at <code>http://localhost:9100</code>.</p>
            </li>
        </ol>
        <h2>Interacting with API Endpoints</h2>
        <p>The Library Management System provides several API endpoints for managing books, users, and borrowing activities. Below is a summary of the main controllers and their endpoints:</p>
        <ul>
            <li>
                <p><strong>BookController</strong>: Manages books in the library.</p>
                <ul>
                    <li>
                        <p><strong><code>GET /books</code></strong></p>
                        <ul>
                            <li><strong>Description</strong>: Retrieve a list of all books in the library.</li>
                            <li><strong>Response</strong>: A JSON array of book objects, each containing details like title, author, ISBN, and availability.</li>
                            <li><strong>Authentication</strong>: Not required.</li>
                        </ul>
                    </li>
                    <li>
                        <p><strong><code>GET /books/{id}</code></strong></p>
                        <ul>
                            <li><strong>Description</strong>: Retrieve details of a specific book by its ID.</li>
                            <li><strong>Path Variable</strong>: <code>id</code> - The unique identifier of the book.</li>
                            <li><strong>Response</strong>: A JSON object containing the book's details.</li>
                            <li><strong>Authentication</strong>: Not required.</li>
                        </ul>
                    </li>
                    <li>
                        <p><strong><code>POST /books</code></strong></p>
                        <ul>
                            <li><strong>Description</strong>: Add a new book to the library.</li>
                            <li><strong>Request Body</strong>: A JSON object containing the book's title, author, ISBN, and other relevant details.</li>
                            <li><strong>Response</strong>: A confirmation message or the details of the newly added book.</li>
                            <li><strong>Authentication</strong>: <strong>Required</strong> (JWT token in <code>Authorization</code> header).</li>
                        </ul>
                    </li>
                    <li>
                        <p><strong><code>PUT /books/{id}</code></strong></p>
                        <ul>
                            <li><strong>Description</strong>: Update the details of an existing book.</li>
                            <li><strong>Path Variable</strong>: <code>id</code> - The unique identifier of the book.</li>
                            <li><strong>Request Body</strong>: A JSON object containing the updated details of the book.</li>
                            <li><strong>Response</strong>: A confirmation message or the updated book details.</li>
                            <li><strong>Authentication</strong>: <strong>Required</strong> (JWT token in <code>Authorization</code> header).</li>
                        </ul>
                    </li>
                    <li>
                        <p><strong><code>DELETE /books/{id}</code></strong></p>
                        <ul>
                            <li><strong>Description</strong>: Remove a book from the library.</li>
                            <li><strong>Path Variable</strong>: <code>id</code> - The unique identifier of the book.</li>
                            <li><strong>Response</strong>: A confirmation message.</li>
                            <li><strong>Authentication</strong>: <strong>Required</strong> (JWT token in <code>Authorization</code> header).</li>
                        </ul>
                    </li>
                </ul>
            </li>
            <h3>Patron Endpoints</h3>
            <h4>1. Get All Patrons</h4>
            <ul>
                <li><strong>Endpoint:</strong> <code>GET /api/patrons</code></li>
                <li><strong>Description:</strong> Retrieves a list of all patrons.</li>
                <li><strong>Response:</strong> A list of patron objects.</li>
            </ul>
            <h4>2. Get Patron by ID</h4>
            <ul>
                <li><strong>Endpoint:</strong> <code>GET /api/patrons/{id}</code></li>
                <li><strong>Description:</strong> Retrieves a patron by ID.</li>
                <li><strong>Path Variable:</strong> <code>id</code> - ID of the patron.</li>
                <li><strong>Response:</strong> Patron object if found; otherwise, an empty JSON object.</li>
            </ul>
            <h4>3. Add a New Patron</h4>
            <ul>
                <li><strong>Endpoint:</strong> <code>POST /api/patrons</code></li>
                <li><strong>Description:</strong> Adds a new patron to the system.</li>
                <li><strong>Request Body:</strong> <code>PatronPostRequest</code> object containing new patron details.</li>
                <li><strong>Response:</strong> Confirmation message.</li>
            </ul>
            <h4>4. Edit a Patron</h4>
            <ul>
                <li><strong>Endpoint:</strong> <code>PUT /api/patrons/{id}</code></li>
                <li><strong>Description:</strong> Updates an existing patron's details.</li>
                <li><strong>Path Variable:</strong> <code>id</code> - ID of the patron.</li>
                <li><strong>Request Body:</strong> <code>PatronPutRequest</code> object containing updated patron details.</li>
                <li><strong>Response:</strong> Confirmation message or an error if the patron does not exist.</li>
            </ul>
            <h4>5. Delete a Patron</h4>
            <ul>
                <li><strong>Endpoint:</strong> <code>DELETE /api/patrons/{id}</code></li>
                <li><strong>Description:</strong> Deletes a patron by ID.</li>
                <li><strong>Path Variable:</strong> <code>id</code> - ID of the patron.</li>
                <li><strong>Response:</strong> Confirmation message or an error if the patron does not exist.</li>
            </ul>
            <h3>Borrowing Record Endpoints</h3>
            <h4>1. Add Borrowing Record</h4>
            <ul>
                <li><strong>Endpoint:</strong> <code>POST /api/borrow/{bookId}/patron/{patronId}</code></li>
                <li><strong>Description:</strong> Creates a new borrowing record for a book and a patron.</li>
                <li><strong>Path Variables:</strong>
                    <ul>
                        <li><code>bookId</code> - ID of the book.</li>
                        <li><code>patronId</code> - ID of the patron.</li>
                    </ul>
                </li>
                <li><strong>Request Body:</strong> <code>BorrowingRecordPostRequest</code> object containing borrowing details.</li>
                <li><strong>Response:</strong> Confirmation message or errors if book or patron does not exist.</li>
            </ul>
            <h4>2. Get Borrowing Record</h4>
            <ul>
                <li><strong>Endpoint:</strong> <code>GET /api/borrow/{bookId}/patron/{patronId}</code></li>
                <li><strong>Description:</strong> Retrieves a borrowing record by book and patron ID.</li>
                <li><strong>Path Variables:</strong>
                    <ul>
                        <li><code>bookId</code> - ID of the book.</li>
                        <li><code>patronId</code> - ID of the patron.</li>
                    </ul>
                </li>
                <li><strong>Response:</strong> Borrowing record object.</li>
            </ul>
            <h4>3. Edit Borrowing Record</h4>
            <ul>
                <li><strong>Endpoint:</strong> <code>PUT /api/borrow/{bookId}/patron/{patronId}</code></li>
                <li><strong>Description:</strong> Updates an existing borrowing record.</li>
                <li><strong>Path Variables:</strong>
                    <ul>
                        <li><code>bookId</code> - ID of the book.</li>
                        <li><code>patronId</code> - ID of the patron.</li>
                    </ul>
                </li>
                <li><strong>Request Body:</strong> <code>BorrowingRecordPutRequest</code> object containing updated borrowing details.</li>
                <li><strong>Response:</strong> Confirmation message or an error if the record does not exist.</li>
            </ul>
            <li>
                <p><strong>LoginController</strong>: Handles user authentication and JWT token generation.</p>
                <ul>
                    <li><code>POST /login</code>: Authenticate a user and generate a JWT token.</li>
                </ul>
            </li>
            <li>
                <p><strong>PatronController</strong>: Manages library patrons.</p>
                <ul>
                    <li><code>GET /patrons</code>: Retrieve a list of all patrons (Requires authentication).</li>
                    <li><code>POST /patrons</code>: Register a new patron.</li>
                </ul>
            </li>
            <li>
                <p><strong>RegisterController</strong>: Manages user registration.</p>
                <ul>
                    <li><code>POST /register</code>: Register a new user.</li>
                </ul>
            </li>
        </ul>
        <h2>Authentication</h2>
        <p>Authentication is required for certain operations within the application, such as adding a new book or borrowing a book. The authentication process involves the following steps:</p>
        <ol>
            <li>
                <p><strong>Login</strong>: Users authenticate by sending a POST request to the <code>/login</code> endpoint with their credentials (username and password). If the credentials are valid, a JWT token is generated and returned.</p>
            </li>
            <li>
                <p><strong>Using the JWT Token</strong>: The JWT token must be included in the <code>Authorization</code> header of subsequent requests to endpoints that require authentication.</p><pre><div class="dark bg-gray-950 rounded-md border-[0.5px] border-token-border-medium"><div class="flex items-center relative text-token-text-secondary bg-token-main-surface-secondary px-4 py-2 text-xs font-sans justify-between rounded-t-md"><span>makefile</span><div class="flex items-center"><span class="" data-state="closed"><button class="flex gap-1 items-center"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24" class="icon-sm"><path fill="currentColor" fill-rule="evenodd" d="M7 5a3 3 0 0 1 3-3h9a3 3 0 0 1 3 3v9a3 3 0 0 1-3 3h-2v2a3 3 0 0 1-3 3H5a3 3 0 0 1-3-3v-9a3 3 0 0 1 3-3h2zm2 2h5a3 3 0 0 1 3 3v5h2a1 1 0 0 0 1-1V5a1 1 0 0 0-1-1h-9a1 1 0 0 0-1 1zM5 9a1 1 0 0 0-1 1v9a1 1 0 0 0 1 1h9a1 1 0 0 0 1-1v-9a1 1 0 0 0-1-1z" clip-rule="evenodd"></path></svg></button></span></div></div><div class="overflow-y-auto p-4" dir="ltr"><code class="!whitespace-pre hljs language-makefile"><span class="hljs-section">Authorization: Bearer &lt;JWT-token&gt;</span>
</code></div></div></pre></li>
            <li>
                <p><strong>Secure Endpoints</strong>: Endpoints such as <code>POST /books</code> and <code>POST /borrow</code> are secured and require a valid JWT token to access.</p>
            </li>
        </ol>
        <h2>Password Management</h2>
        <ul>
            <li>
                <p><strong>Password Storage</strong>: Passwords are securely hashed using the BCrypt algorithm before storing them in the database. This ensures that even if the database is compromised, the original passwords cannot be easily retrieved.</p>
            </li>
            <li>
                <p><strong>Password Policies</strong>: The application enforces strong password policies, including minimum length and complexity requirements. Users are encouraged to create passwords that include a combination of letters, numbers, and special
                    characters.
                </p>
            </li>
            <li>
                <p><strong>Authentication Flow</strong>: During the login process, the application compares the entered password with the hashed password stored in the database. If the hashes match, authentication is successful, and a JWT token is generated.</p>
            </li>
        </ul>
        <h2>Caching</h2>
        <ul>
            <li>
                <p><strong>Purpose of Caching</strong>: Caching is used to enhance performance by storing frequently accessed data in memory, reducing the need to repeatedly query the database.</p>
            </li>
            <li>
                <p><strong>Implementation</strong>: In this project, caching is implemented in the <code>LibrarianDetailsService</code> class, specifically for the <code>loadUserByUsername</code> method. After the first successful user lookup, the user details
                    are cached to reduce database access on subsequent login attempts.</p>
            </li>
            <li>
                <p><strong>Cache Management</strong>: The cache is designed to automatically refresh after a certain period or when the cached data becomes stale. This ensures that users always have access to the most up-to-date information.</p>
            </li>
        </ul>
        <h2>Aspects</h2>
        <ul>
            <li>
                <p><strong>Purpose of Aspects</strong>: Aspects are used to separate cross-cutting concerns, such as logging and security, from the business logic. This makes the code cleaner and easier to maintain.</p>
            </li>
            <li>
                <p><strong>Implementation</strong>: An aspect is created for the <code>com.Test.Library.Management.System.Controllers</code> package to target POST requests. This aspect can be used to log POST requests, enforce security measures, or perform
                    other cross-cutting tasks.</p>
            </li>
            <li>
                <p><strong>How It Works</strong>: The aspect intercepts methods annotated with <code>@PostMapping</code> in the specified package. When a POST request is made, the aspect’s advice is executed before or after the controller’s method, depending
                    on the aspect’s configuration.</p>
            </li>
        </ul>
        <hr>
        <p>This documentation should provide a clear understanding of how to run the application, interact with the API, and the underlying implementation details related to authentication, password management, caching, and aspects.</p>
    </div>
</div>
