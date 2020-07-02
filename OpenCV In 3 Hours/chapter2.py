# BASIC FUNCTIONS

import cv2
import numpy as np

img = cv2.imread("Resources/lena.png")
kernel = np.ones((5, 5), np.uint8)  # 5 by 5 matrix of ones

imgGray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)  # convert to grayscale image
imgBlur = cv2.GaussianBlur(imgGray, (7, 7), 0)  # use Gaussian blur function
imgCanny = cv2.Canny(img, 150, 200)  # canny edge detector
imgDialation = cv2.dilate(imgCanny, kernel, iterations=1)  # dilate the edge for canny
imgEroded = cv2.erode(imgDialation, kernel, iterations=1)  # erode, opposite of dilate

# show the images
cv2.imshow("Gray Image", imgGray)  # gray
cv2.imshow("Blur Image", imgBlur)  # blur
cv2.imshow("Canny Image", imgCanny)  # canny
cv2.imshow("Dilation Image", imgDialation)  # dilated
cv2.imshow("Eroded Image", imgEroded)  # eroded
cv2.waitKey(0)
