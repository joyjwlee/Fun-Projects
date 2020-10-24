# https://www.typingtest.com/select.html
# cd PyAutoGui\typebot
import pyautogui
import time

time.sleep(3)
f = open("aesop.txt", 'r')

for word in f:
    # for char in word:
    #    pyautogui.write(char)
    pyautogui.typewrite(word)
    pyautogui.press("enter")
    time.sleep(0.1)
