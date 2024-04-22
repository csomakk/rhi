import express, { Request, Response } from "express";

const app = express();
const port = 3000;
const java = process.env.JAVA_APP || "127.0.0.1";

app.get("/", function (req: Request, res: Response) {
    res.json({
        "message": "Hello, nice progress on the Interview!"
    });
});

app.get("/data", function (req: Request, res: Response) {
  res.json({
      date: Date.now()
  });
});

app.get("/fromjava", async function (req: Request, res: Response) {
  try {
    const response = await fetch(`http://${java}:8080/data`);
    const responseJson:any = await response.json();
    res.json({
      dataInJavaApp: responseJson.data.replace('202', '200002')
    });
  } catch (error:any) {
    res.status(500).json({ error: error.message });
  }
});

app.listen(port, "0.0.0.0", function () {
  console.log(`App listening on port ${port}!`);
});
