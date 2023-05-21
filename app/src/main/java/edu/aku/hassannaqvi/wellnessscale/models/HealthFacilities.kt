package edu.aku.hassannaqvi.wellnessscale.models

import android.database.Cursor
import edu.aku.hassannaqvi.wellnessscale.contracts.TableContracts.TableHealthFacilities
import edu.aku.hassannaqvi.wellnessscale.core.MainApp._EMPTY_
import org.json.JSONObject

/**
 * Created by hussain.siddiqui on 01/06/2021.
 */

class HealthFacilities {
    var dist_id: String = _EMPTY_
    var uc_Id: String = _EMPTY_
    var hfCode: String = _EMPTY_
    var hfName: String = _EMPTY_

    fun sync(jsonObject: JSONObject): HealthFacilities {
        dist_id = jsonObject.getString(TableHealthFacilities.COLUMN_DIST_ID)
        hfCode = jsonObject.getString(TableHealthFacilities.COLUMN_HF_CODE)
        hfName = jsonObject.getString(TableHealthFacilities.COLUMN_HF_NAME)
        return this
    }

    fun hydrate(cursor: Cursor): HealthFacilities {
        dist_id = cursor.getString(cursor.getColumnIndexOrThrow(TableHealthFacilities.COLUMN_DIST_ID))
        hfCode = cursor.getString(cursor.getColumnIndexOrThrow(TableHealthFacilities.COLUMN_HF_CODE))
        hfName = cursor.getString(cursor.getColumnIndexOrThrow(TableHealthFacilities.COLUMN_HF_NAME))

        return this
    }


}