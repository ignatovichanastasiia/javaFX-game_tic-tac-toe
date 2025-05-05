# SmallGameFX – Rock-Paper-Scissors (Tic-Tac-Toe Style)

##  Project Overview
**SmallGameFX** is a JavaFX-based desktop GUI game built as a simple and interactive version of the classic **rock-paper-scissors** game (sometimes mistaken as tic-tac-toe).  
Designed for learning and demonstration purposes, it showcases JavaFX event handling, image-based GUI interaction, game logic, and Java serialization.

---

## ⚙️ Tech Stack
- **JavaFX 21**
- **Built with Maven** (`mvn package`)
- **IDE:** Eclipse
- **Executable formats:**
  -  Launch4j — smooth execution
  -  jpackage — rendering issues noted

---

##  Output
- Fat JAR: `target/small_game_FX-0.0.1-SNAPSHOT.jar`
- EXE: generated via Launch4j and tested on Windows

---

##  Game Features
- Rock, Paper, Scissors logic with animated feedback
- GUI-based score tracking and round management
- Game resets and limited round control
- Dynamic image changes for both player and computer
- In-game messages and validation

---

## Gameplay Flow
1. Player clicks **Rock**, **Paper**, or **Scissors**
2. Random computer move is generated
3. Images update to reflect choices
4. Score is adjusted based on result
5. After 3 rounds:
   - Displays **Win / Lose / Draw**
   - Offers new game option

---

## Project Structure Highlights
- `Controller.java`: Main JavaFX controller with all event handlers
- `*.fxml`: Scene layout (not shown here)
- `/resources`: Contains image assets (for moves and game states)
- Serialization used for storing simple game state (no DB)

---

## Author
Developed by **Anat Ignatovich** as part of self-learning and UI demonstration.  
This game serves as a portfolio piece to showcase GUI handling, state logic, and basic animation in JavaFX.

