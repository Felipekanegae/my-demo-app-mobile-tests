# My Demo App Mobile Test Automation

Mobile test automation project for the Sauce Labs My Demo App Android application using Appium with Java.

The project was developed to practice and demonstrate automated mobile testing with Appium, applying Page Object Model, BDD with Cucumber, test data management with Apache POI, and reusable test automation components.

## Technologies

- Java
- Appium
- Selenium WebDriver
- Cucumber
- JUnit Platform
- Maven
- AssertJ
- Apache POI
- PicoContainer

## Project Structure

The project follows the Page Object Model (POM) pattern and separates the automation into different domains:

- Login
- Products
- Cart
- Checkout

Test data is stored in an Excel file and loaded according to the test case being executed.

## Test Scenarios

The project contains 16 automated test scenarios covering:

- Login validation
- Product sorting by name
- Product sorting by price
- Product details validation
- Product color selection
- Add product to cart
- Product color display in cart
- Remove product from cart
- Cart total validation
- Checkout without required address information
- Checkout without payment information
- Successful checkout

## Running the Tests

To run the test suites:

```bash
mvn test "-Dtest=LoginTest,ProductsTest,CartTest,CheckoutTest"
