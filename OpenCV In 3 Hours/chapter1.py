# LEARN OPENCV in 3 HOURS with Python | Including 3x Example Projects (2020)
# READ: IMAGES - VIDEO - WEBCAM

import cv2
print("Packge imported")

# show image
"""
img = cv2.imread("Resources/lena.png") # read in image from path
cv2.imshow("Output", img) # display image
cv2.waitKey(0) # wait MS, 0 is indefinite
"""

# show video capture
# cap = cv2.VideoCapture("Resources/test_video.mp4") # create capture object of specific video

cap = cv2.VideoCapture(0)  # 0 sets it to default webcam
cap.set(3, 640)  # assert height as 640
cap.set(4, 480)  # assert width as 480
cap.set(10, 100)  # set brightness

while True:  # go through each frame 1 by 1
    success, img = cap.read()
    cv2.imshow("Video", img)
    if cv2.waitKey(1) and 0xFF == ord('q'):
        break
