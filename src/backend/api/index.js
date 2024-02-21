const express = require('express');
const app = express()


const PORT = 8383;
app.use(express.static('html'))
app.listen(
    PORT,
    () => console.log('I\'m alive at http://localhost:' + PORT)
)
//get
/*
app.get('/', (req, res) => {
    res.status(200).send(<h1>hi</h1>)
})
app.get('/event', (req, res) => {
    if (req.query.type == 'Career Fair') {
        res.status(200).send({
            event: 'Career Fair',
            time: '12:00 PM'
        })
    }
    else {
        res.status(200).send({
            event: 'No Event',
            time: 'NA'
        })
    }

});
*/
//patch

//delete
