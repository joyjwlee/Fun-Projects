# autoclick for cookie clicker
# (285,485)
import pyautogui
import cv2
import time

time.sleep(1)
pyautogui.hotkey("alt", "tab")
time.sleep(1)
pyautogui.click(285, 485)

i = 0

while True:
    pyautogui.click(285, 485)
    i += 1
    if i > 10:
        break
