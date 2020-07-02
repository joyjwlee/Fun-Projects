# WARP PERSPECTIVE

import cv2
import numpy as np

img = cv2.imread("Resources/cards.jpg")

width, height = 250, 350
# points of the corner of card
pts1 = np.float32([[111, 219], [287, 188], [154, 482], [352, 440]])
# points for warped
pts2 = np.float32([[0, 0], [width, 0], [0, height], [width, height]])
# warp matrix
matrix = cv2.getPerspectiveTransform(pts1, pts2)
# create the warped image
imgOutput = cv2.warpPerspective(img, matrix, (width, height))

cv2.imshow("Image", img)
cv2.imshow("Output", imgOutput)
cv2.waitKey(0)
