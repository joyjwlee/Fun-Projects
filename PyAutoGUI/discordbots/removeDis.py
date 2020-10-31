import pyautogui
import time

time.sleep(1)
pyautogui.hotkey("alt", "tab")

i = 0
num = 10  # number of texts to delete
while True:
    time.sleep(1)
    pyautogui.click(575, 990)
    pyautogui.press('up')
    time.sleep(1)
    pyautogui.hotkey("ctrl", "a")
    time.sleep(1)
    pyautogui.hotkey("delete")
    time.sleep(1)
    pyautogui.hotkey("enter")
    time.sleep(1)
    pyautogui.hotkey("enter")
    time.sleep(1)
    i += 1
    if i > num:
        break
