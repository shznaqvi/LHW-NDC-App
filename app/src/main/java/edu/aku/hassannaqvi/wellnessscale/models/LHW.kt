package edu.aku.hassannaqvi.wellnessscale.models

import android.database.Cursor
import edu.aku.hassannaqvi.wellnessscale.contracts.TableContracts.TableLhw
import edu.aku.hassannaqvi.wellnessscale.core.MainApp._EMPTY_
import org.json.JSONObject

/**
 * Created by hussain.siddiqui on 01/06/2021.
 */

class LHW {
    var hf_Code: String = _EMPTY_
    var lhw_Name: String = _EMPTY_
    var lhw_Code: String = _EMPTY_

    fun sync(jsonObject: JSONObject): LHW {
        hf_Code = jsonObject.getString(TableLhw.COLUMN_HF_CODE)
        lhw_Name = jsonObject.getString(TableLhw.COLUMN_LHW_NAME)
        lhw_Code = jsonObject.getString(TableLhw.COLUMN_LHW_CODE)
        return this
    }

    fun hydrate(cursor: Cursor): LHW {
        hf_Code = cursor.getString(cursor.getColumnIndexOrThrow(TableLhw.COLUMN_HF_CODE))
        lhw_Name = cursor.getString(cursor.getColumnIndexOrThrow(TableLhw.COLUMN_LHW_NAME))
        lhw_Code = cursor.getString(cursor.getColumnIndexOrThrow(TableLhw.COLUMN_LHW_CODE))

        return this
    }


}