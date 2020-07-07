# https://www.youtube.com/watch?v=sXjpkcF7rPQ
# https://stackoverflow.com/questions/15088037/python-script-to-do-something-at-the-same-time-every-day

import smtplib, schedule, time

# address, PW, and msg
sender_email = "timeyojeong@gmail.com"
rec_email = "joyjwlee@gmail.com"
password = "qjfTj12tl"
msg = "12:00"
message = "Subject: {}\n\n{}".format("Time Yojeong", msg)

# method to send
def sendMail():
    server = smtplib.SMTP("smtp.gmail.com", 587)
    server.starttls()
    server.login(sender_email, password)
    print("login success")
    server.sendmail(sender_email, rec_email, message)
    print("mail was sent")


# schedule for when to run
schedule.every().day.at("10:00").do(sendMail)
schedule.every().day.at("10:01").do(sendMail)
schedule.every().day.at("10:02").do(sendMail)

while True:
    print("running")
    schedule.run_pending()
    time.sleep(1)

# https://www.reddit.com/r/learnpython/comments/2gxjmr/how_to_host_python_script_online_so_it_can_run_247/
