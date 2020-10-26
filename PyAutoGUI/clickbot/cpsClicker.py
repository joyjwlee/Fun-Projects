# https://clickspeedtest.com/

import pyautogui
import time

time.sleep(1)
pyautogui.hotkey("alt", "tab")
time.sleep(1)
pyautogui.click(800, 550)

pyautogui.PAUSE = 0.000001

for x in range(300):
    pyautogui.click(800, 550)
