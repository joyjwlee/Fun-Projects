# WARP PERSPECTIVE

import cv2
import numpy as np

img = cv2.imread("Resources/cards.jpg")

width,height = 250,350
pts1 = np.float32([[111,219],[287,188],[154,482],[352,440]]) # points of the corner of card
pts2 = np.float32([[0,0],[width,0],[0,height],[width,height]]) # points for warped
matrix = cv2.getPerspectiveTransform(pts1,pts2) # warp matrix
imgOutput = cv2.warpPerspective(img,matrix,(width,height)) # create the warped image

cv2.imshow("Image",img)
cv2.imshow("Output",imgOutput)
cv2.waitKey(0)