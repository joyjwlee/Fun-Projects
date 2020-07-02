# RESIZING AND CROPPING

import cv2
import numpy as np

# original image
img = cv2.imread("Resources/lambo.png")
print(img.shape)

# resized image
imgResize = cv2.resize(img, (1920,1080)) # resize image
print(imgResize.shape)

imgCropped = img[1000:2080, 1000:2920] # range of height then width

cv2.imshow("Image", img)
cv2.imshow("Resized", imgResize)
cv2.imshow("Cropped", imgCropped)
cv2.waitKey(0)