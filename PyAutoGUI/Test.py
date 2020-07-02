import pyautogui
# (180,50)

pyautogui.click(180, 50)
pyautogui.typewrite("Hello World")
pyautogui.hotkey("command", "c")
# pyautogui.typewrite(["enter"])

while True:
    print(pyautogui.position())
