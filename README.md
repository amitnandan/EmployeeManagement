# Employee Management Service using Spring Cloud and Microservices Architecture

This project is an Employee Management Service that utilizes Spring Cloud and follows a microservices architecture. It is built using Java, Spring Boot, Spring Cloud, Hibernate, MySQL, and React.js for the frontend.

## Features

- **Microservices Architecture**: The project is divided into separate microservices that interact with each other to perform various tasks.
  
- **Config Server**: Configuration data is stored in Git, ensuring easy management and versioning of the application configurations.

- **API Gateway**: The API Gateway centralizes and manages all microservice routes effectively, providing a unified entry point for the client application.

- **Service Registry**: Microservices are registered and managed using a Service Registry, enabling dynamic scaling and service discovery.

- **RabbitMQ**: RabbitMQ is used for auto-refresh and displaying real-time results to the users.

- **Frontend with React**: The project integrates a React frontend that provides a user-friendly display of employee data.

## Tech Stack

- Java
- Spring Boot
- Spring Cloud
- Hibernate
- MySQL
- React.js

## Setup Instructions

Follow the steps below to set up and run the application:

1. Clone the repository:

```bash
git clone <repository-url>
cd employee-management-service
```

2. Configure the Config Server:

   - Ensure you have a Git repository to store configuration data.
   - Modify the `application.yml` file of the Config Server microservice to set the Git repository URL.

3. Configure the Database:

   - Ensure you have a MySQL database installed and running.
   - Modify the database configuration in the `application.yml` files of the respective microservices.

4. Start the Microservices:

   - Build each microservice using Maven or Gradle.
   - Run each microservice using the appropriate commands for Spring Boot applications.

5. Start the Frontend:

   - Navigate to the `frontend` directory.
   - Install the required packages using npm or yarn: `npm install` or `yarn install`.
   - Start the React development server: `npm start` or `yarn start`.

6. Access the Application:

   - Open your web browser and navigate to the URL provided by the React development server.

## Contributing

We welcome contributions to enhance the Employee Management Service. If you find any issues or have improvements to suggest, please create a pull request.

## License

This project is licensed under the [MIT License](LICENSE).

## Authors

- [Amit Nandan](https://github.com/amitnandnan)

Feel free to add your name and GitHub profile link to the Authors section above if you were a contributor to this project.

---

Thank you for using the Employee Management Service! We hope you find it useful for your employee management needs. If you encounter any problems or have any questions, please feel free to reach out to us. Happy coding! 🚀
##Tech Stack : 
    Java | Spring Boot | Spring Cloud | 
    Hibernate| MySQL |React.js
###
