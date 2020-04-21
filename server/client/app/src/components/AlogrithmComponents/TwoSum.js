import React, { Component } from 'react'

export default class TwoSum extends Component
{
    constructor(props)
    {
        super(props);   
        this.state = {inputArray: [], targetSum : 0}  
    }

    componentDidMount()
    {
        document.getElementById('description').textContent = 'This algorithm takes in a list and a target, and it will find the indices of the two numbers that sum to the target.'
        window.addEventListener('keypress', function (e) {
            if (e.keyCode === 13 && document.getElementById('algoInput').value !== '') {
                document.getElementById('ListInsert').click();
            }
            if (e.keyCode === 13 && document.getElementById('targetSum').value !== '') {
                document.getElementById('TargetSumInsert').click();
            }
        }, false);
    }

    reset = () => 
    {
        this.setState({inputArray :[], targetSum: 0});
        document.getElementById('outputSection').textContent ='';
        document.getElementById('outputSection2').textContent ='';
    }

    buildInputList = () => {
        const value = document.getElementById('algoInput').value;
        if (value !== '')
        {
            document.getElementById('algoInput').value='';
            this.state.inputArray.push(parseInt(value));
            document.getElementById('outputSection').textContent = "[" + this.state.inputArray + "]";
        }
    }

    setTargetSum = () => {
        const value = document.getElementById('targetSum').value;
        if (value !== '')
        {
            document.getElementById('targetSum').value = '';
            this.setState({targetSum : parseInt(value)});
            document.getElementById('outputSection2').textContent = 'Target sum: ' + this.state.targetSum;
        }
    }

    getTwoSum = () => {
        fetch(process.env.REACT_APP_API_URL + "Algorithm/TwoSum", {
            method: 'post',
            body: "",
            headers: {
                'Content-Type': 'application/json',
            },
            
        }).then(response => response.json())
        .then(responseJSON => 
            
            document.getElementById('solution').textContent = ''
        
        )
        .catch(err => alert(err));
    }

    render() {
        return <>
            <div className="AlgorithmSectionContainer"> 
                <div className="row">
                    <div className="col-sm">
                        <div className="inputSection">
                        <input 
                        className ="CreateFormInput" 
                        name = "AlgorithmInput" 
                        type="number" 
                        placeholder="Insert list to be checked ..."
                        id="algoInput"
                        >
                        </input>
                        </div>
                        <button id ="ListInsert" onClick={this.buildInputList}>
                            Insert Into list
                        </button>

                        <p id="outputSection">
                        List ...
                        </p>
                    </div>

                    <div className="col-sm">
                        <div className="inputSection">
                        <input 
                        className ="CreateFormInput" 
                        name = "AlgorithmInput" 
                        type="number" 
                        placeholder="Insert target sum ..."
                        id="targetSum"
                        >
                        </input>
                        </div>
                        <button id ="TargetSumInsert" onClick={this.setTargetSum}>
                            Insert Target Sum
                        </button>

                        <p id="outputSection2">
                            Target sum:
                        </p>
                    </div>
                </div>

               
                
                {/* <button onClick={}>
                    Submit
                </button>
                */}
                <button onClick={this.reset}>
                    Reset
                </button> 
                
            </div>  

            <div className ="CodeSectionContainer">
                <pre>
                    <code>
                        This
                        Insert
                        Algorithm
                        Test
                        
                    </code>
                </pre>
            </div>
        </>
    }
} 