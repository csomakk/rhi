const express = require("express");

const app = express();
const port = 3000;
const fetch = (...args) => import('node-fetch').then(({default: fetch}) => fetch(...args));
const java = process.env.JAVA_APP || "127.0.0.1";


app.get("/", function (req, res) {
   res.json({
    date: 'wrong server'
  }); 
});

app.get("/data", function (req, res) {
    res.json({
        date: 'wrong server'
    });
  });

app.get("/fromjava", async function (req, res) {
    const response = await fetch(`http://${java}:8080/data`);
    const responseJson = await response.json();
    res.json({
        dataInJavaApp: responseJson.data.replace('202', 'wrong server')
    });
});

app.listen(port, "0.0.0.0", function () {
  console.log(`App listening on port ${port}!`);
});
