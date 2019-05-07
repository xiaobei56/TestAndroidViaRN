/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 */

import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, ToastAndroid, DeviceEventEmitter, Button} from 'react-native';

const instructions = Platform.select({
    ios: 'Press Cmd+R to reload,\n' + 'Cmd+D or shake for dev menu',
    android:
    'Double tap R on your keyboard to reload,\n' +
    'Shake or press menu button for dev menu',
});

export default class App extends Component<Props> {


    constructor(props) {
        super(props);
        this.state = {
            info: "嘟嘟嘟嘟"
        }
    }

    componentWillMount() {
    //注册接收器
        this.testDataListener = DeviceEventEmitter.addListener('testData', e => {//for Android
            ToastAndroid.show(e.data, 2000);
            //更新状态及其他操作

        });
    }


    render() {
        return (
            <View style={styles.container}>
                <Text style={styles.welcome}>{this.state.info}</Text>
                <Text style={styles.instructions}>To get started, edit App.js</Text>
                <Text style={styles.instructions}>{instructions}</Text>

            </View>
        );
    }


}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#F5FCFF',
    },
    welcome: {
        fontSize: 20,
        textAlign: 'center',
        margin: 10,
    },
    instructions: {
        textAlign: 'center',
        color: '#333333',
        marginBottom: 5,
    },
});
