// var nodemailer = require('nodemailer');
import nodemailer from 'nodemailer';

var transporter = nodemailer.createTransport({
  service: 'naver',
  host: 'smtp.naver.com',
  port: 465,
  auth: {
    user: 'protos',
    pass: '2B8YLLCFNFC1'
  }
});

var mailOptions = {
  from: 'protos@naver.com',
  to: 'protos@naver.com',
  subject: 'Sending Email using Node.js',
  html: `<h1 style="color: red;">That was easy!</h1><img src='https://i.pinimg.com/736x/60/b3/b8/60b3b888914534cfa940f458c2143798.jpg'>`
};

// transporter.sendMail(mailOptions, function(error, info){
//   if (error) {
//     console.log(error);
//   } else {
//     console.log('Email sent: ' + info.response);
//   }
// });

async function sendMail() {
  const result = await transporter.sendMail(mailOptions);
  let str = "";
  (result.envelope.to).forEach(email => {
      str += " " + email + "\n";
  });

  str += "전송 완료";

  console.log(str);
}

sendMail();