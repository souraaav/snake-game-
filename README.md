

## 🐍 Snake Game – Java Swing Edition

A classic Snake Game built in Java using the Swing framework. This project demonstrates fundamental game development concepts such as real-time rendering, keyboard input handling, collision detection, and game loop mechanics. It’s a great starting point for beginners exploring Java GUI programming and game logic.

---

### 🚀 Features

- 🎮 **Classic Snake Gameplay**: Navigate the snake to eat food and grow longer while avoiding collisions.
- 🧠 **Simple AI-Free Logic**: Purely player-controlled with no AI interference.
- 🖼️ **Java Swing GUI**: Built using Java Swing for a responsive and interactive graphical interface.
- ⌨️ **Keyboard Controls**: Use arrow keys to control the snake’s direction.
- 💥 **Collision Detection**: Game ends when the snake hits the wall or itself.
- 🧱 **Grid-Based Movement**: Smooth movement across a grid layout.
- 🧪 **Unit Testing Ready**: Easily testable logic with Maven-based test integration.
- 🔄 **CI/CD Workflow**: Automated build and test pipeline using GitHub Actions.

---


---

### 🛠️ How to Run

1. **Clone the repository**:
   ```bash
   git clone https://github.com/souraaav/snake-game-.git
   cd snake-game-
   ```

2. **Build the project using Maven**:
   ```bash
   mvn clean package
   ```

3. **Run the game**:
   ```bash
   java -cp target/snake-game-1.0-SNAPSHOT.jar SnakeGame
   ```

---
demo-
<img width="740" height="781" alt="{91F56E84-89D1-429F-A177-8E57ADFF05B0}" src="https://github.com/user-attachments/assets/f29e7d18-fa23-4593-a9e7-341caaced7a4" />



#### ✅ Key Benefits

- **Automated Testing**: Ensures code quality on every commit.
- **Artifact Upload**: Compiled JARs are available for download from the Actions tab.
- **Dependency Caching**: Speeds up builds using Maven cache.
- **Cross-Platform**: Runs on `ubuntu-latest` for consistency.

---
The Snake Game is a timeless arcade classic that has captivated generations of gamers with its simple yet addictive gameplay. This project is a modern reimplementation of the game using Java and the Swing GUI toolkit. It serves as a practical demonstration of core programming concepts such as object-oriented design, event-driven programming, and real-time rendering. Built with clarity and modularity in mind, this project is ideal for learners and developers interested in game development, Java GUI applications, and CI/CD automation.

#### Game Mechanics

At its core, the Snake Game involves maneuvering a snake around a grid to consume food items. Each time the snake eats, it grows longer. The challenge increases as the snake becomes longer and the available space to maneuver decreases. The game ends when the snake collides with itself or the boundaries of the game window.

This implementation uses a grid-based system where the snake moves in discrete steps. The game loop is driven by a `Timer` that triggers periodic updates to the game state. The snake’s movement is controlled via keyboard arrow keys, and collision detection is handled by checking the snake’s head position against its body and the game boundaries.

#### Technical Overview

The game is structured around two main classes:

- **`SnakeGame.java`**: The entry point of the application. It sets up the main window (`JFrame`) and initializes the game panel.
- **`GamePanel.java`**: This class extends `JPanel` and contains the core game logic. It handles rendering, user input, game updates, and collision detection.

The game uses a `Timer` to create a game loop that updates the snake’s position and redraws the screen at regular intervals. The snake is represented as a list of coordinates, and food is randomly placed on the grid. When the snake eats food, its length increases, and the score is updated.

#### User Interface

The UI is built using Java Swing, a robust GUI toolkit for Java. The game window is a fixed-size frame containing a custom panel where the game is rendered. The panel uses the `paintComponent` method to draw the snake, food, and score. The use of double buffering ensures smooth rendering without flickering.

#### Input Handling

Keyboard input is captured using a `KeyAdapter` that listens for arrow key presses. The direction of the snake is updated based on the key pressed, with logic to prevent the snake from reversing into itself (e.g., it cannot go directly from left to right).

#### Game States

The game has three primary states:

1. **Running**: The snake moves, and the player can control it.
2. **Paused**: The game loop is halted, and the screen displays a pause message.
3. **Game Over**: Triggered when the snake collides with itself or the wall. The final score is displayed, and the player can restart the game.

These states are managed using boolean flags and conditional rendering logic within the `GamePanel`.

#### Build System – Maven

The project uses Maven for dependency management and build automation. The `pom.xml` file defines the project structure, dependencies, and build plugins. This makes it easy to compile, test, and package the application consistently across environments.

Key benefits of using Maven:

- **Dependency Management**: Automatically downloads and manages required libraries.
- **Standardized Build Lifecycle**: Simplifies compilation, testing, and packaging.
- **Integration with CI/CD**: Seamlessly integrates with GitHub Actions for automation.

#### Continuous Integration with GitHub Actions

To ensure code quality and streamline development, the project includes a GitHub Actions workflow. This workflow is triggered on every push or pull request to the `main` branch. It performs the following steps:

1. **Checkout Code**: Retrieves the latest code from the repository.
2. **Set Up Java Environment**: Installs JDK 17 using the Temurin distribution.
3. **Build with Maven**: Compiles the code and packages it into a JAR file.
4. **Run Tests**: Executes unit tests to verify functionality.
5. **Upload Artifacts**: Stores the compiled JAR file as a downloadable artifact.

This automation ensures that every code change is validated, reducing the risk of introducing bugs and improving overall reliability.

#### Educational Value

This project is an excellent learning resource for:

- **Java Beginners**: Understand object-oriented programming, GUI development, and event handling.
- **Aspiring Game Developers**: Learn the basics of game loops, rendering, and input management.
- **DevOps Enthusiasts**: Explore CI/CD practices using GitHub Actions and Maven.

#### Future Enhancements

Potential improvements include:

- 🧠 Adding AI-controlled snakes for competitive play
- 🌐 Deploying the game as a web app using JavaFX or a Java-to-JS transpiler
- 🎨 Customizable themes and snake skins
- 📊 Leaderboard integration using a backend service
- 🧪 Code coverage and static analysis integration (e.g., JaCoCo, Checkstyle)
note - To make any changes into the game u have to change it's code please make sure to see the code properly

#### Conclusion

The Snake Game project is more than just a nostalgic throwback—it’s a hands-on exploration of Java programming, game development, and modern software engineering practices. With a clean codebase, automated CI pipeline, and modular design, it’s a solid foundation for further experimentation and learning.
