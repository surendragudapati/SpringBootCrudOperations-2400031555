import React, { useState } from "react";
import axios from "axios";

function AddCenter()
{
    const [centerName,setCenterName] = useState("");
    const [location,setLocation] = useState("");
    const [childCapacity,setChildCapacity] = useState("");
    const [licensed,setLicensed] = useState(true);

    const submitData = async(e) =>
    {
        e.preventDefault();

        if(centerName === "" || location === "" || childCapacity === "")
        {
            alert("All fields are required");
            return;
        }

        const data =
        {
            centerName,
            location,
            childCapacity,
            licensed
        };

        try
        {
            await axios.post(
                "http://localhost:8083/daycare/add",
                data
            );

            alert("Center Added Successfully");

            window.location.reload();
        }
        catch(error)
        {
            alert("Failed To Add Center");
        }
    };

    return(
        <div className="container mt-4">

            <h3>Add Daycare Center</h3>

            <form onSubmit={submitData}>

                <input
                    required
                    className="form-control mb-3"
                    placeholder="Center Name"
                    value={centerName}
                    onChange={(e)=>setCenterName(e.target.value)}
                />

                <input
                    required
                    className="form-control mb-3"
                    placeholder="Location"
                    value={location}
                    onChange={(e)=>setLocation(e.target.value)}
                />

                <input
                    required
                    className="form-control mb-3"
                    type="number"
                    placeholder="Child Capacity"
                    value={childCapacity}
                    onChange={(e)=>setChildCapacity(e.target.value)}
                />

                <select
                    className="form-control mb-3"
                    onChange={(e)=>setLicensed(e.target.value==="true")}
                >
                    <option value="true">Licensed</option>
                    <option value="false">Not Licensed</option>
                </select>

                <button className="btn btn-success">
                    Add Center
                </button>

            </form>

        </div>
    );
}

export default AddCenter;