<div class="flex w-full flex-col gap-1 empty:hidden first:pt-[3px]">
    <div class="markdown prose w-full break-words dark:prose-invert dark">
        <p>Certainly! Here's a template for the documentation:</p>
        <hr>
        <h1>Library Management System - Documentation</h1>
        <h2>Table of Contents</h2>
        <ol>
            <li><a rel="noopener" href="#introduction">Introduction</a></li>
            <li><a rel="noopener" href="#prerequisites">Prerequisites</a></li>
            <li><a rel="noopener" href="#installation">Installation</a></li>
            <li><a rel="noopener" href="#running-the-application">Running the Application</a></li>
            <li><a rel="noopener" href="#api-endpoints">API Endpoints</a></li>
            <li><a rel="noopener" href="#authentication">Authentication</a></li>
            <li><a rel="noopener" href="#testing">Testing</a></li>
            <li><a rel="noopener" href="#troubleshooting">Troubleshooting</a></li>
        </ol>
        <h2>Introduction</h2>
        <p>This documentation provides an overview of the Library Management System, including how to set up, run the application, interact with the various API endpoints, and use the authentication features.</p>
        <h2>Prerequisites</h2>
        <ul>
            <li><strong>Java 11</strong> or higher</li>
            <li><strong>Maven 3.6.3</strong> or higher</li>
            <li><strong>Spring Boot</strong> installed</li>
            <li><strong>MySQL</strong> or any other relational database</li>
            <li>Postman or any other API testing tool</li>
        </ul>
        <h2>Installation</h2>
        <ol>
            <li><strong>Clone the repository:</strong><pre><div class="dark bg-gray-950 rounded-md border-[0.5px] border-token-border-medium"><div class="flex items-center relative text-token-text-secondary bg-token-main-surface-secondary px-4 py-2 text-xs font-sans justify-between rounded-t-md"><span>bash</span><div class="flex items-center"><span class="" data-state="closed"><button class="flex gap-1 items-center"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24" class="icon-sm"><path fill="currentColor" fill-rule="evenodd" d="M7 5a3 3 0 0 1 3-3h9a3 3 0 0 1 3 3v9a3 3 0 0 1-3 3h-2v2a3 3 0 0 1-3 3H5a3 3 0 0 1-3-3v-9a3 3 0 0 1 3-3h2zm2 2h5a3 3 0 0 1 3 3v5h2a1 1 0 0 0 1-1V5a1 1 0 0 0-1-1h-9a1 1 0 0 0-1 1zM5 9a1 1 0 0 0-1 1v9a1 1 0 0 0 1 1h9a1 1 0 0 0 1-1v-9a1 1 0 0 0-1-1z" clip-rule="evenodd"></path></svg>Copy code</button></span></div></div><div class="overflow-y-auto p-4" dir="ltr"><code class="!whitespace-pre hljs language-bash">git <span class="hljs-built_in">clone</span> https://github.com/your-username/library-management-system.git
</code></div></div></pre></li>
            <li><strong>Navigate to the project directory:</strong><pre><div class="dark bg-gray-950 rounded-md border-[0.5px] border-token-border-medium"><div class="flex items-center relative text-token-text-secondary bg-token-main-surface-secondary px-4 py-2 text-xs font-sans justify-between rounded-t-md"><span>bash</span><div class="flex items-center"><span class="" data-state="closed"><button class="flex gap-1 items-center"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24" class="icon-sm"><path fill="currentColor" fill-rule="evenodd" d="M7 5a3 3 0 0 1 3-3h9a3 3 0 0 1 3 3v9a3 3 0 0 1-3 3h-2v2a3 3 0 0 1-3 3H5a3 3 0 0 1-3-3v-9a3 3 0 0 1 3-3h2zm2 2h5a3 3 0 0 1 3 3v5h2a1 1 0 0 0 1-1V5a1 1 0 0 0-1-1h-9a1 1 0 0 0-1 1zM5 9a1 1 0 0 0-1 1v9a1 1 0 0 0 1 1h9a1 1 0 0 0 1-1v-9a1 1 0 0 0-1-1z" clip-rule="evenodd"></path></svg>Copy code</button></span></div></div><div class="overflow-y-auto p-4" dir="ltr"><code class="!whitespace-pre hljs language-bash"><span class="hljs-built_in">cd</span> library-management-system
</code></div></div></pre></li>
            <li><strong>Configure the database:</strong>
                <ul>
                    <li>Open <code>application.properties</code> or <code>application.yml</code>.</li>
                    <li>Set your database configurations (URL, username, password).</li>
                </ul>
            </li>
            <li><strong>Install dependencies:</strong><pre><div class="dark bg-gray-950 rounded-md border-[0.5px] border-token-border-medium"><div class="flex items-center relative text-token-text-secondary bg-token-main-surface-secondary px-4 py-2 text-xs font-sans justify-between rounded-t-md"><span>bash</span><div class="flex items-center"><span class="" data-state="closed"><button class="flex gap-1 items-center"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24" class="icon-sm"><path fill="currentColor" fill-rule="evenodd" d="M7 5a3 3 0 0 1 3-3h9a3 3 0 0 1 3 3v9a3 3 0 0 1-3 3h-2v2a3 3 0 0 1-3 3H5a3 3 0 0 1-3-3v-9a3 3 0 0 1 3-3h2zm2 2h5a3 3 0 0 1 3 3v5h2a1 1 0 0 0 1-1V5a1 1 0 0 0-1-1h-9a1 1 0 0 0-1 1zM5 9a1 1 0 0 0-1 1v9a1 1 0 0 0 1 1h9a1 1 0 0 0 1-1v-9a1 1 0 0 0-1-1z" clip-rule="evenodd"></path></svg>Copy code</button></span></div></div><div class="overflow-y-auto p-4" dir="ltr"><code class="!whitespace-pre hljs language-bash">mvn clean install
</code></div></div></pre></li>
        </ol>
        <h2>Running the Application</h2>
        <ol>
            <li><strong>Run the application:</strong><pre><div class="dark bg-gray-950 rounded-md border-[0.5px] border-token-border-medium"><div class="flex items-center relative text-token-text-secondary bg-token-main-surface-secondary px-4 py-2 text-xs font-sans justify-between rounded-t-md"><span>bash</span><div class="flex items-center"><span class="" data-state="closed"><button class="flex gap-1 items-center"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24" class="icon-sm"><path fill="currentColor" fill-rule="evenodd" d="M7 5a3 3 0 0 1 3-3h9a3 3 0 0 1 3 3v9a3 3 0 0 1-3 3h-2v2a3 3 0 0 1-3 3H5a3 3 0 0 1-3-3v-9a3 3 0 0 1 3-3h2zm2 2h5a3 3 0 0 1 3 3v5h2a1 1 0 0 0 1-1V5a1 1 0 0 0-1-1h-9a1 1 0 0 0-1 1zM5 9a1 1 0 0 0-1 1v9a1 1 0 0 0 1 1h9a1 1 0 0 0 1-1v-9a1 1 0 0 0-1-1z" clip-rule="evenodd"></path></svg>Copy code</button></span></div></div><div class="overflow-y-auto p-4" dir="ltr"><code class="!whitespace-pre hljs language-bash">mvn spring-boot:run
</code></div></div></pre>or<pre><div class="dark bg-gray-950 rounded-md border-[0.5px] border-token-border-medium"><div class="flex items-center relative text-token-text-secondary bg-token-main-surface-secondary px-4 py-2 text-xs font-sans justify-between rounded-t-md"><span>bash</span><div class="flex items-center"><span class="" data-state="closed"><button class="flex gap-1 items-center"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24" class="icon-sm"><path fill="currentColor" fill-rule="evenodd" d="M7 5a3 3 0 0 1 3-3h9a3 3 0 0 1 3 3v9a3 3 0 0 1-3 3h-2v2a3 3 0 0 1-3 3H5a3 3 0 0 1-3-3v-9a3 3 0 0 1 3-3h2zm2 2h5a3 3 0 0 1 3 3v5h2a1 1 0 0 0 1-1V5a1 1 0 0 0-1-1h-9a1 1 0 0 0-1 1zM5 9a1 1 0 0 0-1 1v9a1 1 0 0 0 1 1h9a1 1 0 0 0 1-1v-9a1 1 0 0 0-1-1z" clip-rule="evenodd"></path></svg>Copy code</button></span></div></div><div class="overflow-y-auto p-4" dir="ltr"><code class="!whitespace-pre hljs language-bash">java -jar target/library-management-system-0.0.1-SNAPSHOT.jar
</code></div></div></pre></li>
            <li>The application will start on <code>http://localhost:8080</code>.</li>
        </ol>
        <h2>API Endpoints</h2>
        <h3>1. <strong>BookController</strong></h3>
        <ul>
            <li>
                <p><strong>Get All Books</strong></p>
                <ul>
                    <li><strong>Endpoint:</strong> <code>GET /books</code></li>
                    <li><strong>Description:</strong> Retrieve all books.</li>
                    <li><strong>Response:</strong><pre><div class="dark bg-gray-950 rounded-md border-[0.5px] border-token-border-medium"><div class="flex items-center relative text-token-text-secondary bg-token-main-surface-secondary px-4 py-2 text-xs font-sans justify-between rounded-t-md"><span>json</span><div class="flex items-center"><span class="" data-state="closed"><button class="flex gap-1 items-center"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24" class="icon-sm"><path fill="currentColor" fill-rule="evenodd" d="M7 5a3 3 0 0 1 3-3h9a3 3 0 0 1 3 3v9a3 3 0 0 1-3 3h-2v2a3 3 0 0 1-3 3H5a3 3 0 0 1-3-3v-9a3 3 0 0 1 3-3h2zm2 2h5a3 3 0 0 1 3 3v5h2a1 1 0 0 0 1-1V5a1 1 0 0 0-1-1h-9a1 1 0 0 0-1 1zM5 9a1 1 0 0 0-1 1v9a1 1 0 0 0 1 1h9a1 1 0 0 0 1-1v-9a1 1 0 0 0-1-1z" clip-rule="evenodd"></path></svg>Copy code</button></span></div></div><div class="overflow-y-auto p-4" dir="ltr"><code class="!whitespace-pre hljs language-json"><span class="hljs-punctuation">[</span>
  <span class="hljs-punctuation">{</span>
    <span class="hljs-attr">"id"</span><span class="hljs-punctuation">:</span> <span class="hljs-number">1</span><span class="hljs-punctuation">,</span>
    <span class="hljs-attr">"title"</span><span class="hljs-punctuation">:</span> <span class="hljs-string">"Book Title"</span><span class="hljs-punctuation">,</span>
    <span class="hljs-attr">"author"</span><span class="hljs-punctuation">:</span> <span class="hljs-string">"Author Name"</span><span class="hljs-punctuation">,</span>
    <span class="hljs-attr">"isbn"</span><span class="hljs-punctuation">:</span> <span class="hljs-string">"1234567890"</span><span class="hljs-punctuation">,</span>
    <span class="hljs-attr">"publishedDate"</span><span class="hljs-punctuation">:</span> <span class="hljs-string">"2023-01-01"</span>
  <span class="hljs-punctuation">}</span>
<span class="hljs-punctuation">]</span>
</code></div></div></pre></li>
                </ul>
            </li>
            <li>
                <p><strong>Create a Book</strong></p>
                <ul>
                    <li><strong>Endpoint:</strong> <code>POST /books</code></li>
                    <li><strong>Description:</strong> Add a new book to the library.</li>
                    <li><strong>Request Body:</strong><pre><div class="dark bg-gray-950 rounded-md border-[0.5px] border-token-border-medium"><div class="flex items-center relative text-token-text-secondary bg-token-main-surface-secondary px-4 py-2 text-xs font-sans justify-between rounded-t-md"><span>json</span><div class="flex items-center"><span class="" data-state="closed"><button class="flex gap-1 items-center"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24" class="icon-sm"><path fill="currentColor" fill-rule="evenodd" d="M7 5a3 3 0 0 1 3-3h9a3 3 0 0 1 3 3v9a3 3 0 0 1-3 3h-2v2a3 3 0 0 1-3 3H5a3 3 0 0 1-3-3v-9a3 3 0 0 1 3-3h2zm2 2h5a3 3 0 0 1 3 3v5h2a1 1 0 0 0 1-1V5a1 1 0 0 0-1-1h-9a1 1 0 0 0-1 1zM5 9a1 1 0 0 0-1 1v9a1 1 0 0 0 1 1h9a1 1 0 0 0 1-1v-9a1 1 0 0 0-1-1z" clip-rule="evenodd"></path></svg>Copy code</button></span></div></div><div class="overflow-y-auto p-4" dir="ltr"><code class="!whitespace-pre hljs language-json"><span class="hljs-punctuation">{</span>
  <span class="hljs-attr">"title"</span><span class="hljs-punctuation">:</span> <span class="hljs-string">"New Book Title"</span><span class="hljs-punctuation">,</span>
  <span class="hljs-attr">"author"</span><span class="hljs-punctuation">:</span> <span class="hljs-string">"Author Name"</span><span class="hljs-punctuation">,</span>
  <span class="hljs-attr">"isbn"</span><span class="hljs-punctuation">:</span> <span class="hljs-string">"1234567890"</span><span class="hljs-punctuation">,</span>
  <span class="hljs-attr">"publishedDate"</span><span class="hljs-punctuation">:</span> <span class="hljs-string">"2023-01-01"</span>
<span class="hljs-punctuation">}</span>
</code></div></div></pre></li>
                    <li><strong>Response:</strong><pre><div class="dark bg-gray-950 rounded-md border-[0.5px] border-token-border-medium"><div class="flex items-center relative text-token-text-secondary bg-token-main-surface-secondary px-4 py-2 text-xs font-sans justify-between rounded-t-md"><span>json</span><div class="flex items-center"><span class="" data-state="closed"><button class="flex gap-1 items-center"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24" class="icon-sm"><path fill="currentColor" fill-rule="evenodd" d="M7 5a3 3 0 0 1 3-3h9a3 3 0 0 1 3 3v9a3 3 0 0 1-3 3h-2v2a3 3 0 0 1-3 3H5a3 3 0 0 1-3-3v-9a3 3 0 0 1 3-3h2zm2 2h5a3 3 0 0 1 3 3v5h2a1 1 0 0 0 1-1V5a1 1 0 0 0-1-1h-9a1 1 0 0 0-1 1zM5 9a1 1 0 0 0-1 1v9a1 1 0 0 0 1 1h9a1 1 0 0 0 1-1v-9a1 1 0 0 0-1-1z" clip-rule="evenodd"></path></svg>Copy code</button></span></div></div><div class="overflow-y-auto p-4" dir="ltr"><code class="!whitespace-pre hljs language-json"><span class="hljs-punctuation">{</span>
  <span class="hljs-attr">"id"</span><span class="hljs-punctuation">:</span> <span class="hljs-number">2</span><span class="hljs-punctuation">,</span>
  <span class="hljs-attr">"title"</span><span class="hljs-punctuation">:</span> <span class="hljs-string">"New Book Title"</span><span class="hljs-punctuation">,</span>
  <span class="hljs-attr">"author"</span><span class="hljs-punctuation">:</span> <span class="hljs-string">"Author Name"</span><span class="hljs-punctuation">,</span>
  <span class="hljs-attr">"isbn"</span><span class="hljs-punctuation">:</span> <span class="hljs-string">"1234567890"</span><span class="hljs-punctuation">,</span>
  <span class="hljs-attr">"publishedDate"</span><span class="hljs-punctuation">:</span> <span class="hljs-string">"2023-01-01"</span>
<span class="hljs-punctuation">}</span>
</code></div></div></pre></li>
                </ul>
            </li>
        </ul>
        <h3>2. <strong>BorrowingController</strong></h3>
        <ul>
            <li><strong>Borrow a Book</strong>
                <ul>
                    <li><strong>Endpoint:</strong> <code>POST /borrow</code></li>
                    <li><strong>Description:</strong> Borrow a book from the library.</li>
                    <li><strong>Request Body:</strong><pre><div class="dark bg-gray-950 rounded-md border-[0.5px] border-token-border-medium"><div class="flex items-center relative text-token-text-secondary bg-token-main-surface-secondary px-4 py-2 text-xs font-sans justify-between rounded-t-md"><span>json</span><div class="flex items-center"><span class="" data-state="closed"><button class="flex gap-1 items-center"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24" class="icon-sm"><path fill="currentColor" fill-rule="evenodd" d="M7 5a3 3 0 0 1 3-3h9a3 3 0 0 1 3 3v9a3 3 0 0 1-3 3h-2v2a3 3 0 0 1-3 3H5a3 3 0 0 1-3-3v-9a3 3 0 0 1 3-3h2zm2 2h5a3 3 0 0 1 3 3v5h2a1 1 0 0 0 1-1V5a1 1 0 0 0-1-1h-9a1 1 0 0 0-1 1zM5 9a1 1 0 0 0-1 1v9a1 1 0 0 0 1 1h9a1 1 0 0 0 1-1v-9a1 1 0 0 0-1-1z" clip-rule="evenodd"></path></svg>Copy code</button></span></div></div><div class="overflow-y-auto p-4" dir="ltr"><code class="!whitespace-pre hljs language-json"><span class="hljs-punctuation">{</span>
  <span class="hljs-attr">"bookId"</span><span class="hljs-punctuation">:</span> <span class="hljs-number">1</span><span class="hljs-punctuation">,</span>
  <span class="hljs-attr">"patronId"</span><span class="hljs-punctuation">:</span> <span class="hljs-number">1</span><span class="hljs-punctuation">,</span>
  <span class="hljs-attr">"borrowDate"</span><span class="hljs-punctuation">:</span> <span class="hljs-string">"2024-08-15"</span>
<span class="hljs-punctuation">}</span>
</code></div></div></pre></li>
                    <li><strong>Response:</strong> 200 OK</li>
                </ul>
            </li>
        </ul>
        <h3>3. <strong>LoginController</strong></h3>
        <ul>
            <li><strong>Authenticate User</strong>
                <ul>
                    <li><strong>Endpoint:</strong> <code>POST /login</code></li>
                    <li><strong>Description:</strong> Authenticate user and generate a JWT token.</li>
                    <li><strong>Request Body:</strong><pre><div class="dark bg-gray-950 rounded-md border-[0.5px] border-token-border-medium"><div class="flex items-center relative text-token-text-secondary bg-token-main-surface-secondary px-4 py-2 text-xs font-sans justify-between rounded-t-md"><span>json</span><div class="flex items-center"><span class="" data-state="closed"><button class="flex gap-1 items-center"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24" class="icon-sm"><path fill="currentColor" fill-rule="evenodd" d="M7 5a3 3 0 0 1 3-3h9a3 3 0 0 1 3 3v9a3 3 0 0 1-3 3h-2v2a3 3 0 0 1-3 3H5a3 3 0 0 1-3-3v-9a3 3 0 0 1 3-3h2zm2 2h5a3 3 0 0 1 3 3v5h2a1 1 0 0 0 1-1V5a1 1 0 0 0-1-1h-9a1 1 0 0 0-1 1zM5 9a1 1 0 0 0-1 1v9a1 1 0 0 0 1 1h9a1 1 0 0 0 1-1v-9a1 1 0 0 0-1-1z" clip-rule="evenodd"></path></svg>Copy code</button></span></div></div><div class="overflow-y-auto p-4" dir="ltr"><code class="!whitespace-pre hljs language-json"><span class="hljs-punctuation">{</span>
  <span class="hljs-attr">"username"</span><span class="hljs-punctuation">:</span> <span class="hljs-string">"user"</span><span class="hljs-punctuation">,</span>
  <span class="hljs-attr">"password"</span><span class="hljs-punctuation">:</span> <span class="hljs-string">"password"</span>
<span class="hljs-punctuation">}</span>
</code></div></div></pre></li>
                    <li><strong>Response:</strong><pre><div class="dark bg-gray-950 rounded-md border-[0.5px] border-token-border-medium"><div class="flex items-center relative text-token-text-secondary bg-token-main-surface-secondary px-4 py-2 text-xs font-sans justify-between rounded-t-md"><span>json</span><div class="flex items-center"><span class="" data-state="closed"><button class="flex gap-1 items-center"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24" class="icon-sm"><path fill="currentColor" fill-rule="evenodd" d="M7 5a3 3 0 0 1 3-3h9a3 3 0 0 1 3 3v9a3 3 0 0 1-3 3h-2v2a3 3 0 0 1-3 3H5a3 3 0 0 1-3-3v-9a3 3 0 0 1 3-3h2zm2 2h5a3 3 0 0 1 3 3v5h2a1 1 0 0 0 1-1V5a1 1 0 0 0-1-1h-9a1 1 0 0 0-1 1zM5 9a1 1 0 0 0-1 1v9a1 1 0 0 0 1 1h9a1 1 0 0 0 1-1v-9a1 1 0 0 0-1-1z" clip-rule="evenodd"></path></svg>Copy code</button></span></div></div><div class="overflow-y-auto p-4" dir="ltr"><code class="!whitespace-pre hljs language-json"><span class="hljs-punctuation">{</span>
  <span class="hljs-attr">"token"</span><span class="hljs-punctuation">:</span> <span class="hljs-string">"jwt-token-string"</span>
<span class="hljs-punctuation">}</span>
</code></div></div></pre></li>
                </ul>
            </li>
        </ul>
        <h3>4. <strong>PatronController</strong></h3>
        <ul>
            <li><strong>Register a Patron</strong>
                <ul>
                    <li><strong>Endpoint:</strong> <code>POST /register</code></li>
                    <li><strong>Description:</strong> Register a new patron in the library.</li>
                    <li><strong>Request Body:</strong><pre><div class="dark bg-gray-950 rounded-md border-[0.5px] border-token-border-medium"><div class="flex items-center relative text-token-text-secondary bg-token-main-surface-secondary px-4 py-2 text-xs font-sans justify-between rounded-t-md"><span>json</span><div class="flex items-center"><span class="" data-state="closed"><button class="flex gap-1 items-center"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24" class="icon-sm"><path fill="currentColor" fill-rule="evenodd" d="M7 5a3 3 0 0 1 3-3h9a3 3 0 0 1 3 3v9a3 3 0 0 1-3 3h-2v2a3 3 0 0 1-3 3H5a3 3 0 0 1-3-3v-9a3 3 0 0 1 3-3h2zm2 2h5a3 3 0 0 1 3 3v5h2a1 1 0 0 0 1-1V5a1 1 0 0 0-1-1h-9a1 1 0 0 0-1 1zM5 9a1 1 0 0 0-1 1v9a1 1 0 0 0 1 1h9a1 1 0 0 0 1-1v-9a1 1 0 0 0-1-1z" clip-rule="evenodd"></path></svg>Copy code</button></span></div></div><div class="overflow-y-auto p-4" dir="ltr"><code class="!whitespace-pre hljs language-json"><span class="hljs-punctuation">{</span>
  <span class="hljs-attr">"name"</span><span class="hljs-punctuation">:</span> <span class="hljs-string">"Patron Name"</span><span class="hljs-punctuation">,</span>
  <span class="hljs-attr">"email"</span><span class="hljs-punctuation">:</span> <span class="hljs-string">"email@example.com"</span><span class="hljs-punctuation">,</span>
  <span class="hljs-attr">"password"</span><span class="hljs-punctuation">:</span> <span class="hljs-string">"password"</span>
<span class="hljs-punctuation">}</span>
</code></div></div></pre></li>
                    <li><strong>Response:</strong> 201 Created</li>
                </ul>
            </li>
        </ul>
        <h2>Authentication</h2>
        <p>The application uses JWT (JSON Web Token) for securing certain endpoints. Authentication is required for accessing the <code>BookController</code> and other protected resources.</p>
        <h3>Steps to Authenticate:</h3>
        <ol>
            <li>
                <p><strong>Obtain a Token:</strong></p>
                <ul>
                    <li>Send a POST request to <code>/login</code> with valid credentials.</li>
                    <li>The response will include a JWT token.</li>
                </ul>
            </li>
            <li>
                <p><strong>Use the Token:</strong></p>
                <ul>
                    <li>For protected endpoints, include the token in the <code>Authorization</code> header.</li>
                    <li>Example:<pre><div class="dark bg-gray-950 rounded-md border-[0.5px] border-token-border-medium"><div class="flex items-center relative text-token-text-secondary bg-token-main-surface-secondary px-4 py-2 text-xs font-sans justify-between rounded-t-md"><span>bash</span><div class="flex items-center"><span class="" data-state="closed"><button class="flex gap-1 items-center"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24" class="icon-sm"><path fill="currentColor" fill-rule="evenodd" d="M7 5a3 3 0 0 1 3-3h9a3 3 0 0 1 3 3v9a3 3 0 0 1-3 3h-2v2a3 3 0 0 1-3 3H5a3 3 0 0 1-3-3v-9a3 3 0 0 1 3-3h2zm2 2h5a3 3 0 0 1 3 3v5h2a1 1 0 0 0 1-1V5a1 1 0 0 0-1-1h-9a1 1 0 0 0-1 1zM5 9a1 1 0 0 0-1 1v9a1 1 0 0 0 1 1h9a1 1 0 0 0 1-1v-9a1 1 0 0 0-1-1z" clip-rule="evenodd"></path></svg>Copy code</button></span></div></div><div class="overflow-y-auto p-4" dir="ltr"><code class="!whitespace-pre hljs language-bash">Authorization: Bearer your-jwt-token
</code></div></div></pre></li>
                </ul>
            </li>
        </ol>
        <h2>Testing</h2>
        <p>To run the tests, use the following command:</p><pre><div class="dark bg-gray-950 rounded-md border-[0.5px] border-token-border-medium"><div class="flex items-center relative text-token-text-secondary bg-token-main-surface-secondary px-4 py-2 text-xs font-sans justify-between rounded-t-md"><span>bash</span><div class="flex items-center"><span class="" data-state="closed"><button class="flex gap-1 items-center"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24" class="icon-sm"><path fill="currentColor" fill-rule="evenodd" d="M7 5a3 3 0 0 1 3-3h9a3 3 0 0 1 3 3v9a3 3 0 0 1-3 3h-2v2a3 3 0 0 1-3 3H5a3 3 0 0 1-3-3v-9a3 3 0 0 1 3-3h2zm2 2h5a3 3 0 0 1 3 3v5h2a1 1 0 0 0 1-1V5a1 1 0 0 0-1-1h-9a1 1 0 0 0-1 1zM5 9a1 1 0 0 0-1 1v9a1 1 0 0 0 1 1h9a1 1 0 0 0 1-1v-9a1 1 0 0 0-1-1z" clip-rule="evenodd"></path></svg>Copy code</button></span></div></div><div class="overflow-y-auto p-4" dir="ltr"><code class="!whitespace-pre hljs language-bash">mvn <span class="hljs-built_in">test</span>
</code></div></div></pre>
        <p>The tests include unit tests for controllers and services, ensuring the application works as expected.</p>
        <h2>Troubleshooting</h2>
        <h3>Common Issues:</h3>
        <ul>
            <li><strong>Database Connection Error:</strong> Ensure your database is running and the credentials in the <code>application.properties</code> are correct.</li>
            <li><strong>Port Already in Use:</strong> If port 8080 is in use, change the port in <code>application.properties</code>.</li>
        </ul>
        <hr>
        <p>Feel free to modify the details to match your specific implementation!</p>
    </div>
</div>
