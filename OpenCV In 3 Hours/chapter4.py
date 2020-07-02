# SHAPES AND TEXTS

import cv2
import numpy as np

# 0 is black, 1 is white
img = np.zeros((512, 512))  # grayscale image
# print(img.shape)
img = np.zeros((512, 512, 3), np.uint8)  # 3 channels, 255
# print(img.shape)
# print(img)

# img[:] = 255,0,0 # changes entire image to be blue

cv2.line(img, (0, 0), (img.shape[1], img.shape[0]), (0, 255, 0), 3)  # line
# cv2.rectangle(img,(0,0),(250,350),(0,0,255), cv2.FILLED) # filled rectangle
cv2.rectangle(img, (0, 0), (250, 350), (0, 0, 255), 2)  # border rectangle
cv2.circle(img, (400, 50), 30, (255, 255, 0), 5)  # circle
cv2.putText(img, " OPEN CV ", (300, 200),
            cv2.FONT_HERSHEY_COMPLEX, 1, (255, 255, 255), 1)

cv2.imshow("Image", img)
cv2.waitKey(0)
