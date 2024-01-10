import React from "react";
import { Link } from "react-router-dom";
import BasicLayout from "../layouts/BasicLayout";

function MainPage(props) {
    return (
        <BasicLayout>
            <div className="{'text-3xl}">메인 페이지</div>
        </BasicLayout>
    );
}

export default MainPage;