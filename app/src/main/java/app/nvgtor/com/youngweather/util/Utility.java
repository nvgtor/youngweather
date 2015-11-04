package app.nvgtor.com.youngweather.util;

import android.text.TextUtils;

import app.nvgtor.com.youngweather.db.YoungWeatherDB;
import app.nvgtor.com.youngweather.model.City;
import app.nvgtor.com.youngweather.model.County;
import app.nvgtor.com.youngweather.model.Province;

/**
 * Created by nvgtor on 2015/11/4.
 */
public class Utility {

    /**
     * 解析和处理服务器返回的省级数据
     * @param youngWeatherDB
     * @param response
     * @return
     */
    public synchronized static boolean handleProvincesResponse(YoungWeatherDB youngWeatherDB
    , String response){
        if (!TextUtils.isEmpty(response)){
            String[] allProvince = response.split(",");
            if (allProvince != null && allProvince.length > 0){
                for (String p : allProvince){
                    String[] array = p.split("\\|");
                    Province province = new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);
                    //将解析出来的数据存储到Province表
                    youngWeatherDB.saveProvince(province);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     * @param youngWeatherDB
     * @param response
     * @param provinceId
     * @return
     */
    public static boolean handleCitiesResponse(YoungWeatherDB youngWeatherDB
    , String response, int provinceId){
        if (!TextUtils.isEmpty(response)){
            String[] allCities = response.split(",");
            if (allCities != null && allCities.length > 0){
                for (String c : allCities){
                    String[] array = c.split("\\|");
                    City city = new City();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    city.setProvinceId(provinceId);
                    //将解析出来的数据存储到City表
                    youngWeatherDB.saveCity(city);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的县级数据
     * @param youngWeatherDB
     * @param response
     * @param cityId
     * @return
     */
    public static boolean handleCountiesResponse(YoungWeatherDB youngWeatherDB
    , String response, int cityId){
        if (!TextUtils.isEmpty(response)){
            String[] allCounties = response.split(",");
            if (allCounties != null && allCounties.length > 0){
                for (String c : allCounties){
                    String[] array = c.split("\\|");
                    County county = new County();
                    county.setCountyCode(array[0]);
                    county.setCountyName(array[1]);
                    county.setCityId(cityId);
                    //将解析出来的数据存储到County表
                    youngWeatherDB.saveCounty(county);
                }
                return true;
            }
        }
        return false;
    }

}
