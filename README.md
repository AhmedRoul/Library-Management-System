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
            <li>
                <p><strong>Clone the Repository</strong>: Begin by cloning the repository to your local machine.</p>
                <pre><code>git clone https://github.com/AhmedRoul/Library-Management-System/</code></pre>
            </li>
            <li>
                <p><strong>Build the Project</strong>: Navigate to the project directory and build the project using Maven or Gradle.</p>
                <pre><code>mvn clean install</code></pre>
            </li>
            <li>
                <p><strong>Run the Application</strong>: Use the following command to run the Spring Boot application.</p>
                <pre><code>mvn spring-boot:run</code></pre>
            </li>
            <li>
                <p><strong>Access the Application</strong>: Once the application is running, you can access it at <code>http://localhost:9100</code>.</p>
            </li>
        </ol>
        <h2 id="interacting-with-api-endpoints">Interacting with API Endpoints</h2>
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
                <li><strong>Response:</strong> Confirmation message or an error if the record cannot be created.</li>
            </ul>
            <h4>2. Get All Borrowing Records</h4>
            <ul>
                <li><strong>Endpoint:</strong> <code>GET /api/borrow</code></li>
                <li><strong>Description:</strong> Retrieves all borrowing records.</li>
                <li><strong>Response:</strong> A list of borrowing records.</li>
            </ul>
            <h4>3. Get Borrowing Record by ID</h4>
            <ul>
                <li><strong>Endpoint:</strong> <code>GET /api/borrow/{id}</code></li>
                <li><strong>Description:</strong> Retrieves a borrowing record by ID.</li>
                <li><strong>Path Variable:</strong> <code>id</code> - ID of the borrowing record.</li>
                <li><strong>Response:</strong> Borrowing record object if found; otherwise, an empty JSON object.</li>
            </ul>
            <h4>4. Return Borrowed Book</h4>
            <ul>
                <li><strong>Endpoint:</strong> <code>PUT /api/borrow/{id}/return</code></li>
                <li><strong>Description:</strong> Marks a borrowed book as returned.</li>
                <li><strong>Path Variable:</strong> <code>id</code> - ID of the borrowing record.</li>
                <li><strong>Response:</strong> Confirmation message or an error if the record cannot be updated.</li>
            </ul>
        </ul>
        <h2 id="authentication">Authentication</h2>
        <p>The system uses JWT (JSON Web Token) for user authentication. To access secured endpoints, you need to include a valid JWT token in the <code>Authorization</code> header of your requests.</p>
        <h3>Generating a Token</h3>
        <ol>
            <li>
                <p>Send a POST request to <code>/api/login</code> with your username and password.</p>
                <pre><code>POST /api/login
{
    "username": "your-username",
    "password": "your-password"
}</code></pre>
            </li>
            <li>
                <p>If the credentials are correct, you will receive a JWT token in the response.</p>
                <pre><code>{
    "token": "your-jwt-token"
}</code></pre>
            </li>
            <li>
                <p>Include this token in the <code>Authorization</code> header as a Bearer token for subsequent requests.</p>
                <pre><code>Authorization: Bearer your-jwt-token</code></pre>
            </li>
        </ol>
        <h2 id="password-management">Password Management</h2>
        <p>Password management includes features for user password changes and resets. These features are designed to be secure and user-friendly.</p>
        <h3>Changing Password</h3>
        <ol>
            <li>
                <p>Send a POST request to <code>/api/change-password</code> with your current password and the new password.</p>
                <pre><code>POST /api/change-password
{
    "currentPassword": "your-current-password",
    "newPassword": "your-new-password"
}</code></pre>
            </li>
            <li>
                <p>Upon successful validation, your password will be updated.</p>
            </li>
        </ol>
        <h3>Resetting Password</h3>
        <ol>
            <li>
                <p>If you forget your password, send a POST request to <code>/api/reset-password</code> with your email address.</p>
                <pre><code>POST /api/reset-password
{
    "email": "your-email@example.com"
}</code></pre>
            </li>
            <li>
                <p>You will receive a password reset link via email. Follow the instructions to reset your password.</p>
            </li>
        </ol>
        <h2 id="caching">Caching</h2>
        <p>The system implements caching to improve performance. Cached data is used to reduce redundant computations and database queries.</p>
        <h3>Cache Configuration</h3>
        <ol>
            <li>
                <p>Configuration is managed through <code>application.properties</code> or <code>application.yml</code>. You can adjust cache settings as needed.</p>
            </li>
            <li>
                <p>Cacheable methods are annotated with <code>@Cacheable</code>, and cache updates with <code>@CachePut</code> and <code>@CacheEvict</code>.</p>
            </li>
        </ol>
        <h2 id="aspects">Aspects</h2>
        <p>Aspects are used to implement cross-cutting concerns such as logging, security, and monitoring.</p>
        <h3>Logging Aspect</h3>
        <p>The logging aspect logs details of method calls, including method names, arguments, and execution time.</p>
        <pre><code>@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* com.example.service..*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        // Log method details
        return joinPoint.proceed();
    }
}</code></pre>
        <h3>Security Aspect</h3>
        <p>The security aspect handles access control and security checks before method execution.</p>
        <pre><code>@Aspect
@Component
public class SecurityAspect {

    @Before("execution(* com.example.controller..*(..))")
    public void checkSecurity(JoinPoint joinPoint) {
        // Security check logic
    }
}</code></pre>
    </div>
</div>
