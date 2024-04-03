### Setting up the Database Connection

1. Create a `configuration.properties` file in your project's directory.

2. Copy and paste the following content into the `configuration.properties` file:

    ```properties
    # Connection String
    # JDBC URL for connecting to the Oracle database
    dbUrl=jdbc:mysql://your_own_dbip:3306/library2
    # Database username
    dbUsername=your_own_dbusername
    # Database password
    dbPassword=your_own_dbpassword
    ```

    - Replace the placeholders with your actual database credentials:
        - `your_own_dbip`: Replace with the IP address or hostname of your Oracle database.
        - `your_own_dbusername`: Replace with your Oracle database username.
        - `your_own_dbpassword`: Replace with your Oracle database password.

3. Save the `configuration.properties` file.

### Establishing a Database Connection

In your Java code, you can establish a database connection using JDBC. Below is a code snippet demonstrating how to do this:

```java
// Establishing a connection to the library database using properties from a configuration file
        DataBaseUtils.createConnection(
                ConfigurationReader.getProperty("library2.db.url"),
                ConfigurationReader.getProperty("library2.db.username"),
                ConfigurationReader.getProperty("library2.db.password")
        );
```

### Using GitHub Secrets for Sensitive Information

To securely store sensitive information such as database credentials, you can use GitHub Secrets. Follow these steps to set up GitHub Secrets:

1. Go to your GitHub repository.

2. Click on the "Settings" tab.

3. In the left sidebar, click on "Secrets".

4. Click on "New repository secret".

5. Enter a name for your secret (e.g., `DB_USERNAME`, `DB_PASSWORD`, `DB_URL`).

6. Enter the corresponding sensitive information in the "Value" field.

7. Click on "Add secret" to save the secret.

Now, you can access these secrets in your GitHub Actions workflow files.
