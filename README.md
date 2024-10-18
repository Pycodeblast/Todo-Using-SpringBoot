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








