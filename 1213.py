# 사용 모듈
import folium
import webbrowser

# 주요 위치
key_pos= [[ '세종대학교 정문', 37.54909, 127.07507],
['구의사거리', 37.54511, 127.08530],
['성수사거리', 37.54217, 127.06399],
['성수역', 37.54458, 127.05605],
['아차산역', 37.55226, 127.08954]]

# 지도 그리기
pos = [key_pos[0][1], key_pos[0][2]]
map = folium.Map(location=pos, zoom_start=15)

for i in range(len(key_pos)) :
    pos = [key_pos[i][1], key_pos[i][2]]
    popup_color = "green"
    folium.Marker(pos, popup=key_pos[i][0], icon=folium.Icon(icon='cloud', color=popup_color)).add_to(map)

# 저장 및 가시화
file_html = "m.html"
map.save(file_html)
webbrowser.open(file_html)
