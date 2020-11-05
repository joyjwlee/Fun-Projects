# https://www.typingtest.com/select.html
# https://www.typingtest.com/test.html?minutes=1&textfile=aesop.txt
# cd PyAutoGui\typebot
import pyautogui
import time

time.sleep(3)
f = open("alphabet.txt", 'r')

for word in f:
    # for char in word:
    # pyautogui.press(char, _pause=False)
    # time.sleep(0.05)  # realistic
    # time.sleep(0.01)  # pretty cool
    pyautogui.typewrite(word)
    pyautogui.press("enter")
