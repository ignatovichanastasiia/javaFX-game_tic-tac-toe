@echo off
echo ============================
echo   Packaging AppImage only
echo ============================

REM Удаляем старую сборку, если есть
rmdir /s /q output\SmallGameFX 2>nul

REM Собираем AppImage из уже собранного JAR
jpackage ^
  --type app-image ^
  --name SmallGameFX ^
  --dest output ^
  --input target ^
  --main-jar small_game_FX-0.0.1-SNAPSHOT.jar ^
  --main-class application.Main ^
  --module-path "C:\Program Files\JavaFX\javafx-sdk-21\lib" ^
  --add-modules javafx.controls,javafx.fxml ^
  --win-console ^
  --java-options "-Dprism.order=sw"

IF %ERRORLEVEL% EQU 0 (
    echo.
    echo ✅ AppImage готов! Проверяй: output\SmallGameFX\SmallGameFX.exe
) ELSE (
    echo ❌ JPackage завершился с ошибкой.
)

pause