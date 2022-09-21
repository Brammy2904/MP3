const express = require('express');
const cors = require('cors');
var YoutubeMp3Downloader = require("youtube-mp3-downloader");
const app = express();
app.use(cors());
app.listen(4000, () => {
    console.log('Server Works !!! At port 4000');
});
app.get('/download', async (req,res) => {
var YD = new YoutubeMp3Downloader({
  "ffmpegPath": "C:\\Users\\verbe\\eclipse-workspace\\MP3Speler\\src\\main\\resources\\ffmpeg\\ffmpeg.exe",    
  "outputPath": "C:\\Users\\verbe\\eclipse-workspace\\MP3Speler\\src\\main\\resources",    
  "youtubeVideoQuality": "highestaudio",  
  "queueParallelism": 2,                  
  "progressTimeout": 2000,                
  "allowWebm": false                    
});


YD.download(req.query.URL, req.query.title+".mp3");
res.send("Added")

});