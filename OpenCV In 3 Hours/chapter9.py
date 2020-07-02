# FACE DETECTION

import cv2

faceCascade = cv2.CascadeClassifier("Resources/haarcascades/haarcascade_frontalface_default.xml")
img = cv2.imread("Resources/cra cast.jpg")
imgGray = cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)

# get faces and loop through each to plot rectangles
faces = faceCascade.detectMultiScale(imgGray,1.1,4)
for (x,y,w,h) in faces:
    cv2.rectangle(img,(x,y),(x+w,y+h),(255,0,0),2)

cv2.imshow("Image", img)
cv2.waitKey(0)