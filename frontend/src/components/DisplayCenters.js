import React,{useEffect,useState} from "react";
import axios from "axios";

function DisplayCenters()
{
    const [centers,setCenters] = useState([]);

    const loadCenters = async() =>
    {
        try
        {
            const res = await axios.get(
                "http://localhost:8083/daycare/displayall"
            );

            setCenters(res.data);
        }
        catch(error)
        {
            console.log(error);
        }
    };

    const deleteCenter = async(id) =>
    {
        if(window.confirm("Are you sure you want to delete?"))
        {
            await axios.delete(
                `http://localhost:8083/daycare/delete/${id}`
            );

            loadCenters();
        }
    };

    useEffect(()=>
    {
        loadCenters();
    },[]);

    return(
        <div className="container mt-4">

            <h3>All Daycare Centers</h3>

            <table className="table table-bordered table-striped">

                <thead className="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Location</th>
                        <th>Capacity</th>
                        <th>Licensed</th>
                        <th>Action</th>
                    </tr>
                </thead>

                <tbody>

                    {
                        centers.map((center)=>(
                            <tr key={center.id}>
                                <td>{center.id}</td>
                                <td>{center.centerName}</td>
                                <td>{center.location}</td>
                                <td>{center.childCapacity}</td>
                                <td>{center.licensed.toString()}</td>
                                <td>
                                    <button
                                        className="btn btn-danger"
                                        onClick={() =>
                                            deleteCenter(center.id)}
                                    >
                                        Delete
                                    </button>
                                </td>
                            </tr>
                        ))
                    }

                </tbody>

            </table>

        </div>
    );
}

export default DisplayCenters;