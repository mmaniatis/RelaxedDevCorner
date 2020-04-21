import React, { Component } from 'react'

export default class TwoSum extends Component
{
    constructor(props)
    {
        super(props);   
        this.state = {inputArray: []}  
    }

    componentDidMount()
    {
        document.getElementById('description').textContent = 'This algorithm takes in a list and a target, and it will find the indices of the two numbers that sum to the target.'
        window.addEventListener('keypress', function (e) {
            if (e.keyCode === 13 && document.getElementById('algoInput').value !== '') {
                document.getElementById('ListInsert').click();
            }
        }, false);
    }

    reset = () => 
    {
        this.setState({inputArray :[]});
        document.getElementById('outputSection').textContent ='';
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
                        placeholder=""
                        id="algoInput"
                        // onChange ={this.buildTreeNode}
                        >
                        </input>
                        </div>
                        <button id ="ListInsert" onClick={this.buildInputList}>
                            Insert Into list
                        </button>
                    </div>

                    <div className="col-sm">
                        <div className="inputSection">
                        <input 
                        className ="CreateFormInput" 
                        name = "AlgorithmInput" 
                        type="number" 
                        placeholder=""
                        id="targetSum"
                        // onChange ={this.buildTreeNode}
                        >
                        </input>
                        </div>
                        <button id ="ListInsert" onClick={this.buildInputList}>
                            Insert Into list
                        </button>
                    </div>
                </div>

               
                
                {/* <button onClick={}>
                    Submit
                </button>
                */}
                <button onClick={this.reset}>
                    Reset
                </button> 
                <p id="outputSection">
                List ...
                </p>
                
            </div>  
        </>
    }
} 