import { ADD_PRODUCT_BASKET, GET_NUMBERS_IN_BASKET, REMOVE_PRODUCT } from "../actions/types";

const initialState = {
    addedItems: [],
}

   const basketReducer = (state = initialState.addedItems, action) => {
    switch(action.type) {
        case ADD_PRODUCT_BASKET:
            let existed_item= state.find(item=>action.product.id === item.id)
            if(existed_item) {
                return state;
            }
            return [ ...state, action.product]
        case GET_NUMBERS_IN_BASKET:
            return {
                ...state
            }
        case REMOVE_PRODUCT:
            const index = state.findIndex(item => item.name === action.name);
            return state.filter((_, i) => i !== index);
        default:
            return state

    }
}

    
export default basketReducer;

