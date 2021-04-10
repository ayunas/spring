console.log("Welcome to the PMA App");

/*
1. In the Home Controller, get the data from the database using the Repo.
2. convert it to a String using Object Mapper
3. Add it to the model
4. declare a JS variable in the thyemleaf template const chartData = "[[${}]]"
5. remove the quotes and convert it to a real JS object
6. extract the labels and the data points arrays from the JS object.
7. paste these array as values for a new Chart() instance from Chart.js
*/

function quotStringToJsObj(str) {
    const jsonStr = str.replace(/&quot;/g, '"');
    const jsObj = JSON.parse(jsonStr);
    return jsObj;
}

function extractLabelsData(arrObj) {
    const stageLabels = arrObj.map(o => o.stage);
    const projCounts = arrObj.map(p => Number(p.projectCount));
    return [stageLabels, projCounts];
}

const chartJs = quotStringToJsObj(chartData);
const [stageLabels, projCounts] = extractLabelsData(chartJs);

const canvas = document.querySelector("#pieChart");

new Chart(canvas, {
    type: 'pie',
    data: {
        labels: stageLabels,
        datasets: [
            {
                label: "Project Stages",
                backgroundColor: ['rgb(255,99,132)', '#8e5ea2', '#3cba9f'],
                borderColor: 'rgb(255,75,120)',
                data: projCounts
            }
        ]
    },
    options: {
        title: {display: true, text: ""}
    }
})


// var myPieChart = new Chart(ctx, {
//     type: 'pie',
//     data: data,
//     options: options
// });
//
// var c = document.getElementById("pieChart");
// var ctx = c.getContext("2d");
// ctx.moveTo(0, 0);
// ctx.lineTo(200, 100);
// ctx.stroke();


//
// const chartJSON = chartData.replace(/&quot;/g,'"');
// console.log(chartJSON);
//
// const chartJSData = JSON.parse(chartJSON);
// console.log(chartJSData);
//
// const stageLabels = chartJSData.map(proj => proj.stage);
// console.log(stageLabels);
//
// const projCounts = chartJSData.map(p => Number(p.projectCount));
// console.log(projCounts);

//(3) {projectCount: "1", stage: "COMPLETED"}
// 1: {projectCount: "2", stage: "INPROGRESS"}
// 2: {projectCount: "1", stage: "NOTSTARTED"}
// length: 3
// __proto__: Array(0)

//[{&quot;projectCount&quot;:&quot;1&quot;,&quot;stage&quot;:&quot;COMPLETED&quot;},{&quot;projectCount&quot;:&quot;2&quot;,&quot;stage&quot;:&quot;INPROGRESS&quot;},{&quot;projectCount&quot;:&quot;1&quot;,&quot;stage&quot;:&quot;NOTSTARTED&quot;}]


//take the chart data, filter out the non-json,and convert it to a JS object.  Then load it into the new Chart().  as
