# from https://www.youtube.com/watch?v=jBxRGcDmfWA
import pyautogui
import time
time.sleep(3)
# f = open("spambot/beemovie", 'r')
f = open("spambot/beemovie_test", 'r')
for word in f:
    pyautogui.typewrite(word)
    pyautogui.press("enter")
    time.sleep(0.1)
