@echo off
echo ============================
echo   Maven: clean & package
echo ============================

call mvn clean package
IF %ERRORLEVEL% NEQ 0 (
    echo ❌ Maven build failed. Check errors above.
    pause
    exit /b
)

echo.
echo ============================
echo   Creating AppImage with jpackage
echo ============================

REM Удаляем старую сборку
rmdir /s /q output\SmallGameFX 2>nul

REM Запускаем jpackage
jpackage ^
  --type app-image ^
  --name SmallGameFX ^
  --dest output ^
  --input target ^
  --main-jar small_game_FX-0.0.1-SNAPSHOT.jar ^
  --main-class application.Main ^
  --module-path "C:\Program Files\JavaFX\javafx-sdk-24\lib" ^
  --add-modules javafx.controls,javafx.fxml ^
  --win-console ^
  --jvm-args "-Dprism.order=sw"

echo.
echo    output\SmallGameFX\SmallGameFX.exe
pause