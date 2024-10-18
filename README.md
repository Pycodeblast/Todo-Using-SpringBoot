Summary of DAL Workflow:
Mongotodorepo handles MongoDB operations by injecting Todorepo, which provides built-in methods like save(), findById(), and deleteById(). This avoids writing repetitive code and ensures the application stays clean and easy to maintain.

Why Inject Todorepo in MongoTodorepo?
Simplifies code: No need to manually write CRUD queries.
Keeps it modular: If we switch from MongoDB to another database (like PostgreSQL), we only need to change this class, not the rest of the code.
Examples:
Find task by ID: todorepo.findById(id)
Save a new task: todorepo.save(task)

Why Implement Mongorepo in MongoTodorepo?
Abstraction for flexibility: Mongorepo is an interface that abstracts database operations. If needed, we can swap Mongotodorepo with a different implementation (like PostgresTodoRepo) without affecting other parts of the application.
Encourages loose coupling: Using an interface helps ensure different parts of the code depend on abstractions, not specific implementations.

Why We Are Injecting Todorepo in Todoservice?
For Simplicity: If your current application only requires standard CRUD operations and you don't foresee needing custom MongoDB functionality, inject Todorepo directly into Todoservice.
Why We Didn't Inject Mongotodorepo?
For Future Scalability: If you anticipate adding more complex data access logic or possibly switching databases in the future, inject Mongotodorepo. This allows you to maintain a cleaner architecture and promotes better organization of your code.

notes:
ResponseEntity: Used for handling HTTP responses, allowing the specification of status codes (like 200, 404, 400) and returning results or messages along with the HTTP response.

@RequestBody: Binds the incoming JSON request body to a method parameter, enabling the handling of complex data structures directly from the request body for easy data binding.

@PathVariable: Extracts specific values from the URI, enabling the fetching of particular identifiers (like an ID) from the URL to perform operations on specific resources, such as retrieving or deleting a Todo item.




