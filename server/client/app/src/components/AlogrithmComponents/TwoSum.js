import React, { Component } from 'react'

export default class TwoSum extends Component
{
    constructor(props)
    {
     super(props);   
    }

    componentDidMount()
    {

    }

    render() {
        return <>
            <div className="AlgorithmSectionContainer"> 
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
                    {/* <button id ="ListInsert" onClick={}>
                    Insert Into list
                    </button> */}
                </div>
                
                {/* <button onClick={}>
                    Submit
                </button>

                <button onClick={}>
                    Reset
                </button> */}
                <p id="outputSection">
                List ...
                </p>
                
            </div>  
        </>
    }
} 