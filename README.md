# HCI and PRTP Hands-on
![Android Studio Badge](https://img.shields.io/badge/Android%20Studio-3DDC84?logo=androidstudio&logoColor=fff&style=for-the-badge)
![Java Badge](https://img.shields.io/badge/Java-ED8B00?logo=java&logoColor=fff&style=for-the-badge)
![Gradle Badge](https://img.shields.io/badge/Gradle-02303A?logo=gradle&logoColor=fff&style=for-the-badge)
![License Badge](https://img.shields.io/badge/License-MIT-000000?style=for-the-badge)

This repository contains the code and resources for the HCI (Human-Computer Interaction) and PRTP (Parallel and Real-time Programming) Hands-on projects. The projects are developed using Android Studio, Java, and Gradle.

---

## Table of Contents ([TOC](#table-of-contents)) (W.I.P. Since there's no content yet)

**Coming soon (since classes have not started yet):**

*[HCI Hands-on Projects](/HCI/)*

*[PRTP Hands-on Projects](/PRTP/)*

See the [Template](/Template/README.md) to get a blank project template to start your own projects.

## Environment Setup

### Prerequisites 

**Nice to have (Don't worry about it if you can't get it):**
- **Android Studio**: Make sure you have Android Studio installed. You can download it from [here](https://developer.android.com/studio).

It is recommended to use the latest stable version of Android Studio for the best experience. If it's to heavy for your computer, check the [Compiling and Running](#compiling-and-running) section for alternative ways to run the project.

**Required:**

- **Java Development Kit (JDK)**: Ensure you have JDK installed. You can download it from [here](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).
- **Gradle**: Gradle is included with Android Studio, but you can also install it separately if needed. More information can be found [here](https://gradle.org/install/).

If you don't know want to use the Oracle SDK, **you can use OpenJDK.** You can download it from [here](https://openjdk.org/install/). **Or either way use SDKMAN!** to install the JDK. You can find more information about SDKMAN! [here](https://sdkman.io/install).

Either case, make sure the **minimun version of the JDK is 17 (Haven't tested yet, i'll update this once I test it)**. You can check your JDK version by running the following command in your terminal:

```bash
java -version
```

## Compiling and Running

I'll be using both Android Studio and Gradle to compile and run the projects. You can choose either method based on your preference and setup.

### With Android Studio

1. **Clone the repository to your local machine using Git:**

   ```bash
   git clone https://github.com/InozaAki/2026B-HCI-PRTP.git
   ```

2. **Open Android Studio and select "Open an existing project." Navigate to the cloned repository and open it.**

3. **Select the desired Hands-on project from the folder structure in Android Studio.**

4. **Click on the "Run" button (green play icon) in Android Studio to build and run the project on an emulator or a connected Android device.**

### Without Android Studio

1. **Clone the repository to your local machine using Git:**
   ```bash
   git clone https://github.com/InozaAki/2026B-HCI-PRTP.git
   ```
2. **Navigate to the desired Hands-on project directory in the terminal.**
3. **Enable developer mode and USB debugging on your Android device.** (Used to save resources and time, but you can also use an emulator if you prefer.)
4. **Use Gradle to build and run the project on your connected Android device. You can use the following command:**
   ```bash
   ./gradlew installDebug
   ```
5. **After the build is complete, you can launch the app on your Android device. Since Gradle handles the installation, you can find the app in your device's app drawer.**

If you encounter any issues during the setup or running of the projects, please refer to the official documentation of Android Studio, Java, and Gradle for troubleshooting. Or you can reach out to me for assistance.

### Hope ya'll enjoy the projects! If you have any questions or need assistance, don't hesitate to ask.

## Author
**Axel Antonio Espinosa Espinoza**
  - GitHub: [@InozaAki](https://github.com/InozaAki)
  - Email: [axelespinoza887@gmail.com](mailto:axelespinoza887@gmail.com)

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details