
# Snake Game – Classic Arcade Fun in Java

[![Status](https://img.shields.io/badge/status-active-brightgreen)](https://github.com/souraaav/snake-game-)  
[![Java](https://img.shields.io/badge/Java-ED8B00?logo=java&logoColor=white)](https://www.java.com/)  
[![License: MIT](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

A modern take on the timeless Snake game, built using Java Swing. Simple, nostalgic, and addictive.

---

## Summary

This project recreates the classic Snake game using Java's Swing GUI toolkit. It’s a great example of object-oriented design, event-driven programming, and game loop logic. Whether you're a beginner learning Java or a retro game enthusiast, this project is both fun and educational.

---

## Project Overview

- Control the snake using arrow keys  
- Eat food to grow longer and score points  
- Game ends when the snake hits the wall or itself  
- Real-time game loop with smooth rendering  
- Simple and clean UI using Java Swing  

---

## File Descriptions

<details>
<summary><code>GamePanel.java</code></summary>

This is the heart of the game. It handles:

- Game logic (movement, collisions, scoring)  
- Rendering the snake and food  
- Timer-based game loop  
- Key event handling for snake control  

</details>

<details>
<summary><code>SnakeGame.java</code></summary>

This is the entry point of the application. It:

- Sets up the main game window  
- Initializes the `GamePanel`  
- Configures window properties (title, size, close operation)  

</details>

---

## Technologies Used

- Java – Core programming language  
- Swing – GUI framework for rendering the game  
- OOP Principles – Modular and maintainable code structure  

---

## Getting Started

### Prerequisites

- Java JDK 8 or higher  
- Any Java IDE (e.g., IntelliJ IDEA, Eclipse) or terminal with `javac`  

### Installation & Run

```bash
# Clone the repository
git clone https://github.com/souraaav/snake-game-.git
cd snake-game-

# Compile the game
javac SnakeGame.java GamePanel.java

# Run the game
java SnakeGame
```

---

## Demo

[![Live Demo](https://img.shields.io/badge/Live%20Demo-Click%20Here-blue?style=for-the-badge)](https://your-live-demo-link.com)

> Add a GIF or screenshot below to showcase gameplay

![Snake Game Screenshot](https://your-screenshot-link.com/snake-game.png)

---

## Future Enhancements

- Dark mode toggle  
- Background music and sound effects  
- High score tracking  
- Mobile-friendly version using JavaFX or Android  
- Deploy as a web app using Java WebAssembly  

---

## License

This project is licensed under the [MIT License](LICENSE).

